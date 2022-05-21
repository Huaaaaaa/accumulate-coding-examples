package com.accumulate.coding.basic.io.nio.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 7:13 下午
 * @description: 网络编程客户端
 */
public class NioNetClient {

    public static void main(String[] args) throws IOException {
        //得到一个通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞模式
        socketChannel.configureBlocking(false);

        //提供服务端地址
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 5555);
        //连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {
            System.out.println("连接服务器失败");
        }

        String message = "hello world~";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        //将buffer数据写入channel
        int write = socketChannel.write(buffer);
        System.out.println("客户端写完,write=" + write);
    }
}
