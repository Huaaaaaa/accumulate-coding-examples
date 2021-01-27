package com.accumulate.coding.middle.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: Huaaaaaa
 * DateTime: 2021/1/26  20:06
 * Description:
 */
public interface JedisGetService<T> {

    String getString(String key);

    T getList(String key);

    T getSet(String key);

    T getHash(String key);

    T getData(String key, String valueType);
}
