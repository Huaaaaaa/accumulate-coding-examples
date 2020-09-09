package com.accumulate.coding.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName JsonUtil
 * @Date 2020/9/8  16:41
 */
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * from object to json string
     *
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj) {

        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * from json string to object
     *
     * @param str
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T toObject(String str, Class<T> cls) {

        try {
            return MAPPER.readValue(str, cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    //这里我们直接传递一个Type类型
    public static <T> T fromJson(String str, TypeReference type) {
        try {
            return (T) MAPPER.readValue(str, type);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
