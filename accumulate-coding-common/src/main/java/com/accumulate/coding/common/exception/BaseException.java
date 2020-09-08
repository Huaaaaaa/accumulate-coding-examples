package com.accumulate.coding.common.exception;

import com.accumulate.coding.common.constants.ExceptionStatus;
import com.accumulate.coding.common.enums.ResultCode;
import com.accumulate.coding.common.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Date 2020/9/8  15:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseException extends RuntimeException {


    private static final long serialVersionUID = 1477845764361778808L;


    private Integer code;

    private String message;

    private Map<String, Object> details;

    public BaseException(ResultCode resultCode) {
        super(getMessageByCode(resultCode.getCode(), resultCode.getMessage()));
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BaseException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(ResultCode resultCode, String detailJson) {
        super(getMessageByCode(resultCode.getCode(), resultCode.getMessage()));
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.details = JsonUtil.toObject(detailJson, Map.class);
    }

    public static String getMessageByCode(int code, String message) {
        return String.valueOf(code).startsWith("5") ? ExceptionStatus.INTERNAL_ERROR : message;
    }


}
