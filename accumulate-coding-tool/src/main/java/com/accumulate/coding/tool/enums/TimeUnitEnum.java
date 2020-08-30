package com.accumulate.coding.tool.enums;

/**
 * @ClassName TimeUnitEnum
 * @Description
 * @Date 2020/8/18  12:08
 */
public enum TimeUnitEnum {

    TIME_UNIT_HOUR(1, "小时"),
    TIME_UNIT_DAY(2, "天"),
    TIME_UNIT_MONTH(3, "月"),
    TIME_UNIT_YEAR(4, "年");

    private int code;

    private String message;


    TimeUnitEnum() {
    }

    TimeUnitEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }}
