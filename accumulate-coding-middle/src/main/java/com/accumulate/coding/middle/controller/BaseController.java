package com.accumulate.coding.middle.controller;

import com.accumulate.coding.common.resp.BaseApiResponse;

/**
 * Author: Huaaaaaa
 * DateTime: 2021/1/27  11:46
 * Description:
 */
public class BaseController<T> {



    protected BaseApiResponse getResponse(T data) {
        BaseApiResponse<Object> response = new BaseApiResponse<>();
        response.setData(data);
        return response;
    }



}
