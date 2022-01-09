package com.accumulate.coding.basic.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 3:34 下午
 * @description:
 */
public class NioReadFile {

    public static void main(String[] args) throws Exception {
        //要读取的文件
        File file = new File("/tmp/nio.txt");
        //创建文件输入流
        FileInputStream fis = new FileInputStream(file);
        //获取通道
        FileChannel channel = fis.getChannel();
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate((int) file.length());
        //将通道的数据读入到buffer中
        channel.read(buffer);
        //将buffer中的字节转成字符串
        System.out.println(new String(buffer.array()));

    }
}
