package com.accumulate.coding.common.controller;

import com.accumulate.coding.common.enums.ResultCode;
import com.accumulate.coding.common.error.BaseError;
import com.accumulate.coding.common.resp.BaseApiResponse;
import com.accumulate.coding.common.resp.BaseResponse;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Date 2020/9/8  15:20
 */
public class BaseController<T> {

    public BaseApiResponse baseApiResponse(T data, String requestId, ResultCode resultCode) {
        BaseApiResponse baseApiResponse = new BaseApiResponse();
        if (ResultCode.isTrue(resultCode)) {
            baseApiResponse.setData(data);
        } else {
            baseApiResponse.setError(BaseError.error(resultCode));
        }
        baseApiResponse.setRequestId(requestId);
        return baseApiResponse;
    }


    public BaseApiResponse baseApiResponse(BaseResponse response, String requestId) {
        return baseApiResponse((T) response.getData(), requestId, response.getResultCode());
    }
}
