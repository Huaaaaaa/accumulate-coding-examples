package com.accumulate.coding.basic.io.nio.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 6:53 下午
 * @description: 网络编程---服务端
 */
public class NioNetServer {

    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //获取一个Selector对象
        Selector selector = Selector.open();
        //绑定端口，在服务器端进行监听
        serverSocketChannel.socket().bind(new InetSocketAddress(5555));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //把ServerSocketChannel注册到Selector上，关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //循环等待客户端连接
        while (true) {
            //等待1秒，无连接事件发生，则返回
            if (selector.select(1000) == 0) { // 没有事件发生
                System.out.println("服务器已经等到1秒钟，未发生连接事件，继续");
                continue;
            }

            //当有事件发生时，获取到相关的SelectionKey集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //通过SelectionKey集合反向获取通道
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
            while (keyIterator.hasNext()) {
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据key对应的通道所发生的事件，做相应的处理
                if (key.isAcceptable()) {
                    System.out.println("有accept事件发生,给该客户端生成一个SocketChannel");
                    //给该客户端生成一个SocketChannel
                    SocketChannel accept = serverSocketChannel.accept();
                    //将socketChannel设置为非阻塞
                    accept.configureBlocking(false);
                    //将当前的channel注册到selector上，关注事件为READ，同时给socketChannel关联一个buffer
                    SelectionKey selectionKey = accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    System.out.println("客户端连接成功后，read事件注册结果，selectionKey=" + selectionKey + " 事件个数：" + selectionKeys.size());

                }

                if (key.isReadable()) {
                    System.out.println("有read事件发生,通过key获取到对应的SocketChannel");
                    //通过key获取到对应的SocketChannel");
                    SocketChannel channel = (SocketChannel) key.channel();
                    //将socketChannel设置为非阻塞
                    channel.configureBlocking(false);
                    //获取到该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    //从Chanel中读取数据到buffer
                    channel.read(buffer);
                    System.out.println("读取到来自客户端的请求数据：" + new String(buffer.array()));
                    buffer.clear();
                }

                //手动从集合中移除当前的SelectionKey，防止重复操作
                keyIterator.remove();
            }
        }

    }
}
