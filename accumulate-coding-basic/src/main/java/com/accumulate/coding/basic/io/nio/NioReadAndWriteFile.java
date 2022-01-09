package com.accumulate.coding.basic.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 3:41 下午
 * @description: 通过一个buffer完成文件的输入输出
 */
public class NioReadAndWriteFile {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("static/from.txt");
        FileChannel inChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("static/to.txt");
        FileChannel outChannel = fos.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(512);
        while (true) {
            //重要操作：复位-clear，即清空buffer，如果不清空，position=limit，导致一一直读取到0
            buffer.clear();
            int read = inChannel.read(buffer);
            System.out.println(read);
            if (read == -1) {
                break;
            }

            //将buffer中的数据写入到新文件
            buffer.flip();
            outChannel.write(buffer);
        }

        //关闭流
        fis.close();
        fos.close();

    }
}
