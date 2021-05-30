package com.accumulate.coding.basic.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Date:  2020/10/30
 * Todo:
 * Time 17:06
 */
public class DataUtil {

    private static final Logger logger = LoggerFactory.getLogger(DataUtil.class);

    public static Map<String, Object> toBinaryString(int data) {
        Map<String, Object> resMap = new HashMap<>();
        String binData = Integer.toBinaryString(data);
        String binReverseData = new StringBuffer(binData).reverse().toString();
        resMap.put("binData", binData);
        resMap.put("binReverseData", binReverseData);
        logger.info("resMap={}", resMap.toString());
        return resMap;
    }

}
