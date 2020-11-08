package com.accumulate.coding.basic.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Date:  2020/11/8
 * Todo: JSON工具类
 * Time 18:56
 */
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * Object to json string
     * @param o
     * @return
     */
    public static String toJsonString(Object o){
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    /**
     * String to object
     * @param jsonStr
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T toObject(String jsonStr,Class<T> cls){
        try {
            return objectMapper.readValue(jsonStr,cls);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    /**
     * String to specified class
     * @param jsonStr
     * @param tTypeReference
     * @param <T>
     * @return
     */
    public static <T> T toObject(String jsonStr, TypeReference<T> tTypeReference){
        try {
            return objectMapper.readValue(jsonStr,tTypeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


}
