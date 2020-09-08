package com.accumulate.coding.common.enums;

/**
 * @ClassName ResultCode
 * @Description
 * @Date 2020/9/8  15:24
 */
public enum ResultCode {

    SUCCESS(200, "Success"),
    INTERNAL_ERROR(500, "Internal Server Error");

    private int code;


    private String message;


    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


    public static Boolean isTrue(ResultCode resultCode) {
        return resultCode.equals(ResultCode.SUCCESS);
    }

}
