package com.realestate.properties.service;

import com.realestate.properties.domain.User;
import com.realestate.properties.exceptions.BaseException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    User loadUserById(Long id) throws UsernameNotFoundException;

    User insert(User user);

    void checkNewUser(User user) throws BaseException;

    Boolean isEmailUsed(String email);

    User getUserByID(Long id);
}
