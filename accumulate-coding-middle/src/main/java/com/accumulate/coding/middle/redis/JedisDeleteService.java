package com.accumulate.coding.middle.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author: Huaaaaaa
 * DateTime: 2021/1/26  20:08
 * Description:
 */
public interface JedisDeleteService {

    boolean deleteString(String key);

    boolean deleteList(String key);

    boolean deleteSet(String key);

    boolean deleteSortedSet(String key);

    boolean deleteHash(String key);

    boolean deleteData(String key, Class dataType);
}
