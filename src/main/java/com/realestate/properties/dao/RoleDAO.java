package com.realestate.properties.dao;

import com.realestate.properties.domain.Role;

import java.util.List;

public interface RoleDAO {

    void insert2User(Long userID, Long roleID);

    List<Role> getUserRoles(Long userID);
}
