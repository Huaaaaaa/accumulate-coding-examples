package com.accumulate.coding.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName ParameterTypeService
 * @User huayingcao2
 * @Description TODO
 * @Date 2020/9/9  17:17
 */
public class ParameterTypeService implements ParameterizedType {

    private Type rawType;//真实类型

    private Type actualType;//泛型类型

    public ParameterTypeService(Type rawType, Type actualType) {
        this.rawType = rawType;
        this.actualType = actualType;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return new Type[0];
    }

    @Override
    public Type getRawType() {
        return null;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
