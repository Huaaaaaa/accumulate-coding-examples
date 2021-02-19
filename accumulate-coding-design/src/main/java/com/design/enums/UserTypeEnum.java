package com.design.enums;

import java.util.Arrays;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/6
 * Todo:
 * Time 8:30
 */
public enum UserTypeEnum {

    NO_FREE(1, "需支付用户"),
    FREE(2, "免支付用户");

    private int code;

    private String value;

    UserTypeEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByCode(int code) {
        return Arrays.stream(UserTypeEnum.values()).filter(userTypeEnum -> userTypeEnum.getCode() == code).findFirst().map(UserTypeEnum::getValue).orElse(null);
    }
}
