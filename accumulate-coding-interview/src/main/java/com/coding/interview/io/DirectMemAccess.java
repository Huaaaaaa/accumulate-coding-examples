package com.coding.interview.io;

import java.nio.ByteBuffer;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2021/12/26 1:10 下午
 * @description: 直接内存访问
 */
public class DirectMemAccess {

    private ByteBuffer byteBuffer1 = ByteBuffer.allocate(1012 * 1024);
    //直接内存访问：直接操作缓冲区内存，无需拷贝
    private ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(1012 * 1024);
}
