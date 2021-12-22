package com.coding.interview.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @Author: Bug改了我
 * @CreateTime: 2021/12/18 9:40 下午
 * @Description: 虾皮面试官问我BigDecimal的源码, 这是真没看过啊！！！
 */
public class JdkSource {

    public static void main(String[] args) {
        //renewFloatAndDouble();
        calculateBinary();
    }

    /**
     * 重新认识float和double
     */
    public static void renewFloatAndDouble() {
        double number1 = 1;
        double number2 = 3;
        //double最多能只能表示17位有效数字，直接截取17位之后的32
        double number3 = 1234567890.222222245332223332;
        //float最多能只能表示8位有效数字，直接截取8位之后的45
        float number4 = 1.222222245f;
        System.out.println("add=" + (number1 + number2));
        System.out.println("div=" + (number1 / number2));
        System.out.println("number3=" + number3);
        System.out.println("number4=" + number4);
        System.out.println("number5=" + new BigDecimal("1234567890.222222245332223332"));
        float zeroF = 0.1f;
        double zeroD = 0.1;
        System.out.println("0.1f=" + zeroF);
        System.out.println("0.1d=" + zeroD);
        BigDecimal bigDecimal1 = new BigDecimal("1");
        BigDecimal bigDecimal2 = new BigDecimal("3");
        System.out.println(bigDecimal1.divide(bigDecimal2, 2, RoundingMode.HALF_DOWN));
    }


    public static void calculateBinary() {
        float dataF = 1234567890.1234567890F;
        double dataD = 1234567890.1234567890;
        //输出：1.23456794E9
        System.out.println("dataF=" + dataF);
        //输出：1.2345678901234567E9
        System.out.println("dataD=" + dataD);
    }


}
