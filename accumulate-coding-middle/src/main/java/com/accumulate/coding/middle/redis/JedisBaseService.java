package com.accumulate.coding.middle.redis;

import redis.clients.jedis.Jedis;

/**
 * Author: Huaaaaaa
 * DateTime: 2021/1/26  20:21
 * Description:
 */
public class JedisBaseService {


    protected Jedis getJedisClient() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.auth("whhik123");
        return jedis;
    }
}
