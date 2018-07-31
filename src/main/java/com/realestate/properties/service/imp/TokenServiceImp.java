package com.realestate.properties.service.imp;

import com.realestate.properties.dto.RedisUser;
import com.realestate.properties.redis.RedisBaseRepository;
import com.realestate.properties.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tokenService")
public class TokenServiceImp implements TokenService {

    @Autowired
    private RedisBaseRepository redisRepository;

    @Override
    public RedisUser findToken(String token) {
        Object result = redisRepository.findObject(token);
        if (result instanceof RedisUser) {
            return (RedisUser) result;
        }

        return null;
    }

    @Override
    public void insertToken(String key, Object value) {
        redisRepository.insertObject(key, value);
    }

    @Override
    public void revokeToken(String key) {
        redisRepository.deleteKey(key);
    }


}
