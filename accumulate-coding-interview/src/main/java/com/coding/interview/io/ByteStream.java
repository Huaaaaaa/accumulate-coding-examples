package com.coding.interview.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/6 5:31 下午
 * @description: 字节跳动面试题：字符流和字节流有什么区别?
 *  字节流操作
 */
public class ByteStream {
    private final String MESSAGE_CN = "众里寻她千百度，蓦然回首，那人却在灯火阑珊处！";
    private final String MESSAGE_EN = "The find her in 1100 degrees, suddenly looking back, that people in the bend!";

    public static void main(String[] args) {
        ByteStream byteStream = new ByteStream();
        File target = new File("/tmp/writeByByteArray.txt");
        try (
                FileOutputStream fos = new FileOutputStream(target);
                FileInputStream fis = new FileInputStream(target)
        ) {
            byteStream.writeByteByByteArray(fos);
            byteStream.readByteByByteArray(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 一次性写入
     */
    public void writeByteAll(FileOutputStream fos) throws IOException {
        fos.write(MESSAGE_EN.getBytes());
    }

    /**
     * 一次写入一个字节
     */
    public void writeByteByOneByte(FileOutputStream fos) throws IOException {
        byte[] bytes = MESSAGE_EN.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            fos.write(bytes[i]);
        }
    }

    /**
     * 一次写入一个字节数组
     */
    public void writeByteByByteArray(FileOutputStream fos) throws IOException {
        byte[] bytes = MESSAGE_EN.getBytes();
        int batchSize = 10;
        int length = bytes.length;
        if (length <= batchSize) {
            fos.write(bytes);
            return;
        }
        int batch = length / batchSize;
        for (int i = 0; i < batch; i++) {
            if (batch - 1 == i) {
                fos.write(bytes, i * batchSize, length - i * batchSize);
            } else {
                fos.write(bytes, i * batchSize, batchSize);
            }
        }
    }


    /**
     * 一次性读入
     */
    public void readByteAll(FileInputStream fis) throws IOException {
        int read = fis.read();
        int count = 0;
        while (read != -1) {
            read = fis.read();
            count++;
        }
        System.out.println("总共读取了" + count + "次");
    }

    /**
     * 一次性读入
     */
    public void readByteByOneByte(FileInputStream fis) throws IOException {
        byte[] buffer = new byte[1];
        int read = fis.read(buffer);
        int count = 0;
        while (read != -1) {
            read = fis.read(buffer);
            count++;
        }
        System.out.println("总共读取了" + count + "个字节");
    }

    /**
     * 一次读一个字节数组
     */
    public void readByteByByteArray(FileInputStream fis) throws IOException {
        int batchSize = 10;
        byte[] buffer = new byte[batchSize];
        int batch;
        int count = 0;
        while ((batch = fis.read(buffer)) != -1) {
            buffer[count] = (byte) batch;
            System.out.println("第" + count + "次读取的是：" + new String(buffer, 0, batchSize, StandardCharsets.UTF_8));
            count++;
        }
        System.out.println("总共读取了" + count + "次");
    }

}
