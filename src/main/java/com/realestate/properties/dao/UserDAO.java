package com.realestate.properties.dao;

import com.realestate.properties.domain.User;

public interface UserDAO {

    User insert(User registerUser);

    Boolean isEmailUsed(String email);

    User getUserByID(Long id);

    User getUserByUsername(String username);
}

