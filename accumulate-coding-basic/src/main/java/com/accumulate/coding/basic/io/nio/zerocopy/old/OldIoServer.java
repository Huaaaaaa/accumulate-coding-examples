package com.accumulate.coding.basic.io.nio.zerocopy.old;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/10 7:07 上午
 * @description: 传统客户端接受数据
 */
public class OldIoServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5566);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            byte[] buffer = new byte[2048];
            while (true) {
                int read = dis.read(buffer, 0, buffer.length);
                if (read == -1) {
                    break;
                } else {
                    System.out.println(new String(buffer));
                }
            }
        }


    }
}
