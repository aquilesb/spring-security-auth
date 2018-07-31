package com.realestate.properties.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("User")
public class RedisUser implements Serializable {
    private String username;
    private String password;
    private List<String> roles;
}
