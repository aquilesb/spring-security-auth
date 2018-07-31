package com.realestate.properties.service.imp;

import com.realestate.properties.dao.RoleDAO;
import com.realestate.properties.domain.Role;
import com.realestate.properties.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    RoleDAO roleDAO;

    @Override
    public void insert2User(Long userID, Long roleID) {
        roleDAO.insert2User(userID, roleID);
    }

    @Override
    public List<Role> getUserRoles(Long userID) {
        return roleDAO.getUserRoles(userID);
    }

}
