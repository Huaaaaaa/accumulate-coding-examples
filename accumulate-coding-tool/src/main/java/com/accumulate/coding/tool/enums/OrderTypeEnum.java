package com.accumulate.coding.tool.enums;

/**
 * @ClassName OrderTypeEnum
 * @Description
 * @Date 2020/8/18  12:17
 */
public enum OrderTypeEnum {

    ORDER_TYPE_NEW(1, "新购"),
    ORDER_TYPE_RENEWAL(2, "续费");

    private int type;

    private String msg;

    OrderTypeEnum() {
    }

    OrderTypeEnum(int type, String msg) {
        this.type = type;
        this.msg = msg;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static OrderTypeEnum getWithType(int type) {
        OrderTypeEnum[] orderTypeEnums = OrderTypeEnum.values();
        OrderTypeEnum orderTypeEnum = null;
        for (OrderTypeEnum orderType : orderTypeEnums) {
            if (orderType.type == type) {
                orderTypeEnum = orderType;
            }
        }
        return orderTypeEnum;
    }

}
