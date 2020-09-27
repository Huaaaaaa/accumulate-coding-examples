package com.accumulate.coding.basic.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ShiftRes<T> {

    /**
     * 返回位移运算后的二进制字符串
     */
    String binaryData;


    /**
     * 返回位移运算后的源类型
     */
    T originData;

    public ShiftRes() {
    }

    public ShiftRes(String binaryData, T originData) {
        this.binaryData = binaryData;
        this.originData = originData;
    }

    @Override
    public String toString() {
        return "ShiftRes{" +
                "binaryData='" + binaryData + '\'' +
                ", originData=" + originData +
                '}';
    }
}
