package com.accumulate.coding.tool.service.impl;

import com.accumulate.coding.common.exception.InvalidParamException;

import java.util.Optional;

/**
 * @ClassName BaseService
 * @Description TODO
 * @Date 2020/9/8  15:34
 */
public class BaseService {

    public void validateParam(Object param, String messageName) {
        Optional.ofNullable(param).orElseThrow(() -> new InvalidParamException(messageName + "is empty"));
    }
}
