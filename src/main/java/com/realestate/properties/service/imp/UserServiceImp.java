package com.realestate.properties.service.imp;

import com.realestate.properties.dao.RoleDAO;
import com.realestate.properties.dao.UserDAO;
import com.realestate.properties.domain.User;
import com.realestate.properties.exceptions.BaseException;
import com.realestate.properties.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDAO.getUserByUsername(username);
        user.setRoles(roleDAO.getUserRoles(user.getId()));
        return user;
    }

    @Override
    public User loadUserById(Long id) {
        User user = userDAO.getUserByID(id);
        user.setRoles(roleDAO.getUserRoles(user.getId()));
        return user;
    }

    @Override
    public Boolean isEmailUsed(String email){
        return userDAO.isEmailUsed(email);
    }

    @Override
    public User getUserByID(Long id) {
        return userDAO.getUserByID(id);
    }

    @Override
    public void checkNewUser(User user) throws BaseException{
        if(user.getId() != null){
            throw new BaseException("New users should not have ID.");
        }

        if(StringUtils.isEmpty(user.getName())){
            throw new BaseException("New users should have name.");
        }

        if(StringUtils.isEmpty(user.getEmail())){
            throw new BaseException("New users should have email.");
        }

        if(isEmailUsed(user.getEmail())){
            throw new BaseException(new StringBuilder("The email '").append(user.getEmail()).append("' is already in use.").toString());
        }

    }

    @Override
    public User insert(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDAO.insert(user);
    }
}
