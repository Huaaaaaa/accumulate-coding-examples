package com.accumulate.coding.tool.enums;

/**
 * @ClassName OrderStatusEnum
 * @Description 订单状态枚举:1-未支付；2-支付完成；3-支付失败；4-取消；5-退款'
 * @Date 2020/8/18  12:18
 */
public enum OrderStatusEnum {

    ORDER_STATUS_NOT_PAY(1, "未支付"),
    ORDER_STATUS_PAY_SUCCESS(2, "支付完成"),
    ORDER_STATUS_PAY_FAILED(3, "支付失败"),
    ORDER_STATUS_FINISHED(4, "订单完成"),
    ORDER_STATUS_FAILED(5, "订单失败"),
    ORDER_STATUS_NOT_CANCEL(6, "取消"),
    ORDER_STATUS_NOT_REFUND(7, "退款");

    private int status;

    private String msg;

    OrderStatusEnum() {
    }


    OrderStatusEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }}
