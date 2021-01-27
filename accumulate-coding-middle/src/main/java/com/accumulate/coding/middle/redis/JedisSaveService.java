package com.accumulate.coding.middle.redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

import java.util.*;
import java.util.logging.Handler;

/**
 * Author: Huaaaaaa
 * DateTime: 2021/1/26  19:57
 * Description:
 */
public interface JedisSaveService<T> {


    boolean saveString(String key, String value);

    boolean saveList(String key, List<String> values);

    boolean saveSet(String key, Set values);

    boolean saveHash(String key, Map<String,String> values);

    boolean saveData(String key, T value);


}
