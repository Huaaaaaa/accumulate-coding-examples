package com.accumulate.coding.basic.io.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 8:11 下午
 * @description:
 */
public class GroupChatServer {

    private Selector selector;

    private ServerSocketChannel serverSocketChannel;

    private static final int PORT = 5566;

    public GroupChatServer() {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void listen() {
        try {
            while (true) {
                int count = selector.select(2000);
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isAcceptable()) {
                            System.out.println("accept事件");
                            SocketChannel accept = serverSocketChannel.accept();
                            accept.configureBlocking(false);
                            accept.register(selector, SelectionKey.OP_READ);
                            System.out.println(accept.getRemoteAddress() + "上线了");
                        }

                        if (key.isReadable()) {
                            System.out.println("read事件");
                            readData(key);
                        }

                        //删除当前key
                        iterator.remove();
                    }
                } else {
                    System.out.println("等待事件中");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void readData(SelectionKey selectionKey) {
        SocketChannel socketChannel = null;
        try {
            socketChannel = (SocketChannel) selectionKey.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(buffer);
            if (read > 0) {
                String message = new String(buffer.array());
                System.out.println("接受到的消息是message=" + message);
                //向其他客户端转发消息
                sendInfoToOtherClient(message, socketChannel);
            }
        } catch (Exception e) {
            try {
                System.out.println(socketChannel.getRemoteAddress() + "离线了.....关闭通道");
                selectionKey.cancel();
                serverSocketChannel.close();
            } catch (IOException ex) {
                System.out.println();
            }
        }
    }

    public void sendInfoToOtherClient(String message, SocketChannel selfSocket) throws IOException {
        System.out.println("服务器转发消息");
        for (SelectionKey key : selector.keys()) {
            Channel channel = key.channel();
            if (channel instanceof SocketChannel && !channel.equals(selfSocket)) {
                SocketChannel targetChannel = (SocketChannel) channel;
                ByteBuffer wrap = ByteBuffer.wrap(message.getBytes());
                int write = targetChannel.write(wrap);
                System.out.println("转发结果 write=" + write);
            }
        }

    }


    public static void main(String[] args) {
        GroupChatServer server = new GroupChatServer();
        server.listen();
    }
}
