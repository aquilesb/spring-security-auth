package com.realestate.properties.redis;

public interface RedisBaseRepository {

    Object findObject(String token);

    void insertObject(String key, Object value);

    void deleteKey(String key);
}
