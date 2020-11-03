package com.accumulate.coding.basic.shift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: huayingcao2
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

    public static void main(String[] args) {
        toBinaryString(183);
    }
}
