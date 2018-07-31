package com.realestate.properties.service;

import com.realestate.properties.dto.RedisUser;

public interface TokenService {

    RedisUser findToken(String token);

    void insertToken(String key, Object value);

    void revokeToken(String key);
}
