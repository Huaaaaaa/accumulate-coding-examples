package com.accumulate.coding.common.resp;

import com.accumulate.coding.common.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName BaseResponse
 * @Description TODO
 * @Date 2020/9/8  15:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = -2781971134228611778L;

    private T data;

    private ResultCode resultCode;


    public BaseResponse(T data) {
        this.data = data;
        this.resultCode = ResultCode.SUCCESS;
    }

    public static BaseResponse success(Class data) {
        return new BaseResponse(data);
    }


}
