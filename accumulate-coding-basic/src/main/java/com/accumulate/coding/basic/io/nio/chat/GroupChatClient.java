package com.accumulate.coding.basic.io.nio.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 8:28 下午
 * @description:
 */
public class GroupChatClient {
    private final String HOST = "127.0.0.1";

    private final int PORT = 5566;

    private Selector selector;

    private SocketChannel socketChannel;

    private String userName;

    public GroupChatClient() {
        try {
            selector = Selector.open();
            socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_READ);
            userName = socketChannel.getLocalAddress().toString().substring(1);
            System.out.println(userName + "准备好了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void sendInfo(String message) {
        message = userName + "说：" + message;
        try {
            socketChannel.write(ByteBuffer.wrap(message.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readInfo() {
        try {
            int select = selector.select();
            if (select > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        String info = new String(buffer.array());
                        System.out.println("从服务端读取到数据 info=" + info);
                    }
                    //删除当前的selectKey
                    iterator.remove();
                }
            } else {
                System.out.println("没有可用的通道");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        GroupChatClient client = new GroupChatClient();
        new Thread(() -> {
            while (true) {
                client.readInfo();
                try {
                    System.out.println("每隔3秒读取数据");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        //发送数据
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            client.sendInfo(scanner.nextLine());
        }

    }


}
