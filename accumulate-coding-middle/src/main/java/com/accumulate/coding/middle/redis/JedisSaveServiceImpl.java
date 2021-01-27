package com.accumulate.coding.middle.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Author: Huaaaaaa
 * DateTime: 2021/1/26  20:16
 * Description: set redis value
 */
@Service
@Slf4j
public class JedisSaveServiceImpl<T> extends JedisBaseService implements JedisSaveService<T> {

    private final String OK = "OK";

    /**
     * 保存字符串类型
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean saveString(String key, String value) {
        log.info("JedisSaveServiceImpl saveString begin:key={},value={}", key, value);
        String res = getJedisClient().set(key, value);
        log.info("JedisSaveServiceImpl saveString end:res={}", res);
        if (res.equals(OK)) {
            return true;
        }
        return false;
    }


    /**
     * list
     *
     * @param key
     * @param values
     * @return
     */
    @Override
    public boolean saveList(String key, List<String> values) {
        log.info("JedisSaveServiceImpl saveList begin:key={},values={}", key, values);
        if (CollectionUtils.isEmpty(values)) {
            return false;
        }
        Jedis jedis = getJedisClient();
        Long sum = 0L;
        for (String value : values) {
            sum += jedis.lpush(key, value);
        }
        log.info("JedisSaveServiceImpl saveList end:sum={}", sum);
        return sum > 0;
    }


    /**
     * set
     *
     * @param key
     * @param values
     * @return
     */
    @Override
    public boolean saveSet(String key, Set values) {
        log.info("JedisSaveServiceImpl saveSet begin:key={},values={}", key, values);
        if (CollectionUtils.isEmpty(values)) {
            return false;
        }
        Jedis jedis = getJedisClient();
        long sum = 0L;
        for (Object value : values) {
            sum += jedis.sadd((String) value);
        }
        log.info("JedisSaveServiceImpl saveSet end:sum={}", sum);
        return sum > 0;
    }

    /**
     * hash
     *
     * @param key
     * @param values
     * @return
     */
    @Override
    public boolean saveHash(String key, Map<String, String> values) {
        log.info("JedisSaveServiceImpl saveHash begin:key={},values={}", key, values);
        Jedis jedis = getJedisClient();
        AtomicReference<Long> sum = new AtomicReference<>(0L);
        values.entrySet().forEach(value -> {
            sum.updateAndGet(v -> v + jedis.hset(key, value.getKey(), value.getValue()));
        });
        log.info("JedisSaveServiceImpl saveHash end:sum={}", sum);
        return sum.get() == values.size();
    }

    /**
     * all types
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean saveData(String key, T value) {
        if (value instanceof String) {
            return saveString(key, (String) value);
        }
        if (value instanceof List) {
            return saveList(key, (List) value);
        }
        if (value instanceof Set) {
            return saveSet(key, (Set) value);
        }
        if (value instanceof Map) {
            return saveHash(key, (Map<String, String>) value);
        }
        return false;
    }

    private boolean getRes(Object value) {
        return value == null;
    }
}
