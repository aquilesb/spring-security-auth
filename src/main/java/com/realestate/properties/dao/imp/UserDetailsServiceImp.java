package com.realestate.properties.dao.imp;

import com.realestate.properties.domain.User;
import com.realestate.properties.service.RoleService;
import com.realestate.properties.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User)userService.loadUserByUsername(username);
        user.setRoles(roleService.getUserRoles(user.getId()));
        return user;
    }
}
