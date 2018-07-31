package com.realestate.properties.redis.imp;

import com.realestate.properties.redis.RedisBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository("redisRepository")
public class RedisBaseRepositoryImp implements RedisBaseRepository {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private ValueOperations valueOperations;

    @PostConstruct
    private void init(){
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public Object findObject(String key){
        return valueOperations.get(key);
    }

    @Override
    public void insertObject(String key, Object value){
        valueOperations.set(key,value);
    }

    @Override
    public void deleteKey(String key){
        redisTemplate.delete(key);
    }
}
