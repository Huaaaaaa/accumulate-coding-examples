package com.accumulate.coding.middle.redis;

import org.springframework.stereotype.Service;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/1/27  16:03
 * Description:
 */
@Service
public class JedisGetServiceImpl<T> extends JedisBaseService implements JedisGetService<T> {

    @Override
    public String getString(String key) {
        return getJedisClient().get(key);
    }

    @Override
    public T getList(String key) {
        return (T) getJedisClient().lpop(key);
    }

    @Override
    public T getSet(String key) {
        return (T) getJedisClient().spop(key);
    }

    @Override
    public T getHash(String key) {
        return (T) getJedisClient().hgetAll(key);
    }

    @Override
    public T getData(String key, String valueType) {
        switch (valueType) {
            case "string":
                return (T) getString(key);
            case "set":
                return getSet(key);
            case "list":
                return getList(key);
            case "hash":
                return getHash(key);
            default:
                return (T) getString(key);
        }
    }
}
