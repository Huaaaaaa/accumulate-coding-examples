package com.accumulate.coding.basic.io.nio;

import java.nio.IntBuffer;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 12:13 下午
 * @description: buffer的使用
 */
public class BasicBuffer {

    public static void main(String[] args) {
        //1.创建buffer
        IntBuffer intBuffer = IntBuffer.allocate(5);
        //2.向buffer中存放数据
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }
        //3.读写切换：将buffer转为读状态
        intBuffer.flip();

        //4.从buffer读取数据
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
