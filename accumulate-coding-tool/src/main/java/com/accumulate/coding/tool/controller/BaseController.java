package com.accumulate.coding.tool.controller;

import com.accumulate.coding.common.enums.ResultCode;
import com.accumulate.coding.common.error.BaseError;
import com.accumulate.coding.common.resp.BaseApiResponse;
import com.accumulate.coding.common.resp.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName BaseController
 * @Description TODO
 * @Date 2020/9/8  15:20
 */
public class BaseController {

    public static final Logger loe = LoggerFactory.getLogger(BaseController.class);

    public BaseApiResponse baseApiResponse(Object data, String requestId, ResultCode resultCode) {
        String json = "";
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
        return baseApiResponse(response.getData(), requestId, response.getResultCode());
    }
}
