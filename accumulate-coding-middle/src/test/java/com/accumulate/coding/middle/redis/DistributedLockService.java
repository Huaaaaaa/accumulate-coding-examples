package com.accumulate.coding.middle.redis;

/**
 * @author: me
 * @createTime: 2021/12/20 4:33 下午
 * @description: 分布式锁
 */
public interface DistributedLockService {

    void lock(String key, String value);

    boolean releaseLock(String key);
}
