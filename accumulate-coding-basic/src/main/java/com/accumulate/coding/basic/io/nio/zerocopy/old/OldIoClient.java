package com.accumulate.coding.basic.io.nio.zerocopy.old;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/10 7:10 上午
 * @description:
 */
public class OldIoClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 5566);
        FileInputStream fis = new FileInputStream("/tmp/settings.jar");
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[2048];
        long readCount = 0;
        long total = 0;
        long startTime = System.currentTimeMillis();

        while ((readCount = fis.read(bytes)) >= 0) {
            total += readCount;
            dos.write(bytes);
        }
        System.out.println("发送总字节数：" + total + " 总共耗时：" + (System.currentTimeMillis() - startTime));
        dos.close();
        socket.close();
        fis.close();
    }
}
