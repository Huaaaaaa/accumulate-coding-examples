package com.accumulate.coding.basic.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 5:20 下午
 * @description: 通过buffer数组的形式读取和写入
 */
public class ScatteringAndGathering {

    public static void main(String[] args) throws IOException {

        //开启一个socketServer通道
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //给定端口
        InetSocketAddress isa = new InetSocketAddress(7777);
        //绑定端口到socket
        ssc.socket().bind(isa);
        //创建buffer数组
        ByteBuffer[] bfArray = new ByteBuffer[2];
        bfArray[0] = ByteBuffer.allocate(5);
        bfArray[1] = ByteBuffer.allocate(6);

        //等待客户端连接
        SocketChannel socketChannel = ssc.accept();

        //限制读取的个数
        int messageLen = 11;
        //循环读取
        while (true) {
            int byteRead = 0;
            while (byteRead < messageLen) {
                long read = socketChannel.read(bfArray);
                byteRead += read;
                //查看当前buffer的position和limit
                Arrays.asList(bfArray).stream().map(bb -> "position=" + bb.position() + "   limit=" + bb.limit()).forEach(System.out::println);
            }

            //将所有buffer进行反转
            Arrays.asList(bfArray).forEach(byteBuffer -> byteBuffer.flip());

            //将数据读出并显示
            long byteWrite = 0;
            while (byteWrite < messageLen) {
                long write = socketChannel.write(bfArray);
                byteWrite += write;
            }


            //将所有buffer进行cleer
            Arrays.asList(bfArray).forEach(byteBuffer -> byteBuffer.clear());

            System.out.println("byteRead=" + byteRead + "   byteWrite=" + byteWrite);
        }


    }
}
