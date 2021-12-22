package com.accumulate.coding.middle.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author: me
 * @createTime: 2021/12/20 4:36 下午
 * @description:
 */
@Configuration
public class RedissonConfig {


    private long lockWatchdogTimeout = 30 * 1000;

    public long getLockWatchdogTimeout() {
        return lockWatchdogTimeout;
    }
}
