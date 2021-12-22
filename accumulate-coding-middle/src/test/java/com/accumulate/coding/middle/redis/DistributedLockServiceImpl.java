package com.accumulate.coding.middle.redis;

import com.accumulate.coding.middle.config.RedissonConfig;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: me
 * @createTime: 2021/12/20 4:33 下午
 * @description:
 */
public class DistributedLockServiceImpl implements DistributedLockService {

    @Autowired
    private RedissonConfig redissonConfig;

    @Override
    public void lock(String key, String value) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        RedissonClient redisson = Redisson.create(config);
        RLock lock = redisson.getLock("anyLock");
        lock.lock();
    }

    @Override
    public boolean releaseLock(String key) {
        return false;
    }
}
