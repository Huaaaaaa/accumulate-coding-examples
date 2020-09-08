package com.accumulate.coding.common.exception;

import com.accumulate.coding.common.enums.ResultCode;

/**
 * @ClassName InvalidParamException
 * @Description TODO
 * @Date 2020/9/8  15:58
 */
public class InvalidParamException extends BaseException{


    private static final long serialVersionUID = -1447421726526929732L;

    public InvalidParamException(String message){
        super(400,message);
    }

    public InvalidParamException(ResultCode resultCode){
        super(resultCode);
    }



}
