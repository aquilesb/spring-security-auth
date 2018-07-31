package com.realestate.properties.service;

import com.realestate.properties.domain.Role;

import java.util.List;

public interface RoleService {

    void insert2User(Long userID, Long roleID);

    List<Role> getUserRoles(Long userID);
}
