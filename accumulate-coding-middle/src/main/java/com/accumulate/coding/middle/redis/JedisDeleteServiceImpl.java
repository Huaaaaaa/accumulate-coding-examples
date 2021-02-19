package com.accumulate.coding.middle.redis;

import org.springframework.stereotype.Service;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/1/26  20:13
 * Description:
 */
@Service
public class JedisDeleteServiceImpl extends JedisBaseService implements JedisDeleteService {
    @Override
    public boolean deleteString(String key) {
        return getJedisClient().del(key) > 0;
    }

    @Override
    public boolean deleteList(String key) {
        return getJedisClient().del(key) > 0;
    }

    @Override
    public boolean deleteSet(String key) {
        return getJedisClient().del(key) > 0;
    }

    @Override
    public boolean deleteSortedSet(String key) {
        return getJedisClient().del(key) > 0;
    }

    @Override
    public boolean deleteHash(String key) {
        return getJedisClient().del(key) > 0;
    }

    @Override
    public boolean deleteData(String key, Class dataType) {
        return getJedisClient().del(key) > 0;
    }
}
