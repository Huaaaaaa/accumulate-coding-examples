package com.accumulate.coding.basic.io.nio.zerocopy.news;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/10 7:17 上午
 * @description: 通过零拷贝实现文件传输
 */
public class NewIoServer {

    public static void main(String[] args) throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress(5566);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocketChannel.configureBlocking(false);
        serverSocket.bind(inetSocketAddress);

        ByteBuffer buffer = ByteBuffer.allocate(2048);
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            int readCount = 0;
            while (readCount != -1) {
                readCount = socketChannel.read(buffer);
                buffer.rewind();
            }
        }
    }
}
