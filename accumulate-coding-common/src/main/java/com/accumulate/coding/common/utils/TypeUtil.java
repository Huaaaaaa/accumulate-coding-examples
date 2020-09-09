package com.accumulate.coding.common.utils;

import java.lang.reflect.Type;

/**
 * @ClassName TypeUtil
 * @User huayingcao2
 * @Description TODO
 * @Date 2020/9/9  16:47
 */
public class TypeUtil {

    public static Type getParameterType(Type sourceType, Type desType) {
        return new ParameterTypeService(sourceType, desType);
    }

}
