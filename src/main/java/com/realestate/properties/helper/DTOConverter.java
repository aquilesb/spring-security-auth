package com.realestate.properties.helper;

import com.realestate.properties.domain.Role;
import com.realestate.properties.domain.User;
import com.realestate.properties.dto.RedisUser;
import com.realestate.properties.dto.RegisterUser;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.stream.Collectors;

@Component
public class DTOConverter {

    public User convertRegister2User(RegisterUser registerUser){
        User user = new User();
        user.setId(registerUser.getId());
        user.setName(registerUser.getName());
        user.setEmail(registerUser.getEmail());
        user.setPassword(registerUser.getPassword());
        user.setUsername(registerUser.getUsername());
        return user;
    }

    public RedisUser convertUser2Redis(User user){
        RedisUser redisUser = new RedisUser();
        redisUser.setUsername(user.getUsername());
        redisUser.setPassword(user.getPassword());
        redisUser.setRoles(user.getRoles().stream().map(role -> role.getName()).collect(Collectors.toList()));
        return redisUser;
    }

    public User convertRedis2User(RedisUser redisUser){
        User user = new User();
        user.setPassword(redisUser.getPassword());
        user.setUsername(redisUser.getUsername());
        user.setRoles(redisUser.getRoles().stream().map(role -> new Role(role)).collect(Collectors.toList()));
        return user;
    }

}
