package com.realestate.properties.config.security;

import com.realestate.properties.dao.imp.UserDetailsServiceImp;
import com.realestate.properties.domain.User;
import com.realestate.properties.exceptions.WrongCredentials;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsServiceImp userService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials().toString();

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new WrongCredentials("Username and/or password are invalids.");
        }

        User user;
        try{
            user = (User) userService.loadUserByUsername(username);
        }catch(EmptyResultDataAccessException ex){
            user = null;
        }
        if (user != null && passwordEncoder().matches(password, user.getPassword())) {
            return new UsernamePasswordAuthenticationToken
                    (user, password, user.getAuthorities());
        } else {
            throw new WrongCredentials("Username and/or password are wrong");
        }

    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}

