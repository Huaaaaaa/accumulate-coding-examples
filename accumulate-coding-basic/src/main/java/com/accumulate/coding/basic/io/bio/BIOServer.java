package com.accumulate.coding.basic.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 11:21 上午
 * @description: 同步阻塞BIO演示
 */
public class BIOServer {

    public static void main(String[] args) throws IOException {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            //监听，等待客户端连接
            System.out.println("服务器等待连接");
            Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //可以和客户端通信
                    handler(socket);
                }
            });
        }
    }

    public static void handler(Socket socket) {
        Thread thread = Thread.currentThread();
        System.out.println("线程信息 id=" + thread.getId() + "   线程名称：" + thread.getName());
        //通过socket获取输入流
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[1024];
            while (true) {
                System.out.println("服务器等待客户端发送数据");
                int read = inputStream.read(buffer);
                if (read != -1) {
                    //输出客户端发送的数据
                    System.out.println(new String(buffer, 0, read));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
