package com.accumulate.coding.common.utils;

import java.util.UUID;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo:
 * Time 15:06
 */
public class RandomUtil {

    public static String getUUID() {
        String pId = UUID.randomUUID().toString();
        return pId.toUpperCase();
    }
}
