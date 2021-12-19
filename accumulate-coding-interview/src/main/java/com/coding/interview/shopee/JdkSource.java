package com.coding.interview.shopee;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/18 9:40 下午
 * @Description: 虾皮面试官问我BigDecimal的源码, 这是真没看过啊！！！
 */
public class JdkSource {

    public static void main(String[] args) {
        double number1 = 1;
        double number2 = 3;
        System.out.println(number1 + number2);
        System.out.println(number1 / number2);
        BigDecimal bigDecimal1 = new BigDecimal("1");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println(bigDecimal1.divide(bigDecimal2, 2, RoundingMode.HALF_DOWN));
    }
}
