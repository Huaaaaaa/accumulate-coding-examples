package com.accumulate.coding.basic.io.nio.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/9 4:03 下午
 * @description: 通过transferTo拷贝文件
 */
public class NioCopyFile {

    public static void main(String[] args) throws Exception {
        //输入流及通道
        FileInputStream fis = new FileInputStream("static/pic/src.jpeg");
        FileChannel src = fis.getChannel();

        //输出流及通道
        FileOutputStream fos = new FileOutputStream("static/pic/des.jpeg");
        FileChannel des = fos.getChannel();

        des.transferFrom(src, 0, src.size());

        src.close();
        des.close();
        fis.close();
        fos.close();
    }
}
