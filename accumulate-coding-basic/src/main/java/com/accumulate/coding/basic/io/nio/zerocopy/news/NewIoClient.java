package com.accumulate.coding.basic.io.nio.zerocopy.news;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/10 7:23 上午
 * @description:
 */
public class NewIoClient {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 5566));

        FileChannel fileChannel = new FileInputStream("/tmp/settings.jar").getChannel();

        long start = System.currentTimeMillis();

        //transferTo的底层就是零拷贝
        //在linux下，transferTo发送一次就能完成传输
        //在Windows下，一次调用transferTo只能发送8M数据，超出8M的需要分段发送
        long count = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("发送的总字节数=" + count + "耗时=" + (System.currentTimeMillis() - start));
        fileChannel.close();
        socketChannel.close();

    }
}
