package com.coding.interview.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/23 5:45 下午
 * @description:
 */
public class TokenSize {

    public static void main(String[] args) {
        //一个字符占2个字节
        // 如果开启指针压缩（-XX:+UseCompressedOops），token占24字节；
        // 如果关闭指针压缩（-XX:-UseCompressedOops），token占32个字节
        String token = "ADubgkcldowidfdf";
        System.out.println(token.toCharArray().length);
        System.out.println("a".getBytes().length);
        System.out.println(ClassLayout.parseInstance(token).toPrintable());
    }
}
