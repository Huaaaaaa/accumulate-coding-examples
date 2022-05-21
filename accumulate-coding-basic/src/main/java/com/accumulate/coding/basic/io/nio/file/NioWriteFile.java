package com.accumulate.coding.basic.io.nio.file;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 3:24 下午
 * @description:
 */
public class NioWriteFile {

    public static void main(String[] args) throws Exception {
        String content = "hello world!";
        FileOutputStream fos = new FileOutputStream("/tmp/nio.txt");
        //获取通道
        FileChannel channel = fos.getChannel();
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //将内容写入buffer
        buffer.put(content.getBytes());
        //对buffer进行反转
        buffer.flip();
        //将buffer中的数据写入通道
        channel.write(buffer);
        //关闭流
        fos.close();
    }
}
