package com.coding.interview.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: Hu-aaa-aaa
 * @createTime: 2022/1/7 10:40 上午
 * @description: 字符流操作
 */
public class CharStream {

    private final String MESSAGE_CN = "众里寻她千百度，蓦然回首，那人却在灯火阑珊处！";
    private final String MESSAGE_EN = "The find her in 1100 degrees, suddenly looking back, that people in the bend!";

    public static void main(String[] args) {
        CharStream charStream = new CharStream();
        File target = new File("/tmp/writeChar.txt");
        try (
                FileWriter fw = new FileWriter(target);
                FileReader fr = new FileReader(target)
        ) {
            charStream.writeCharByCharArray(fw, charStream.MESSAGE_CN);
            charStream.readCharOneByOne(fr);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 写入整个字符
     *
     * @param fw
     * @throws IOException
     */
    public void writeCharByString(FileWriter fw, String message) throws IOException {
        fw.write(message);
    }

    /**
     * 一个字符一个字符地写入
     *
     * @param fw
     * @throws IOException
     */
    public void writeCharOneByOne(FileWriter fw, String message) throws IOException {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            fw.write(chars[i]);
        }
    }

    /**
     * 按照字符数组写入
     *
     * @param fw
     * @throws IOException
     */
    public void writeCharByCharArray(FileWriter fw, String message) throws IOException {
        int len = 5;
        int count = 0;
        int begin = 0;
        while (begin < message.length()) {
            count++;
            if (message.length() - begin < len) {
                fw.write(message.substring(begin));
            } else {
                fw.write(message.substring(begin, count * len));
            }
            begin = count * len;
        }
    }

    /**
     * 写入整个字符
     *
     * @param fr
     * @throws IOException
     */
    public void readCharByString(FileReader fr) throws IOException {
        int read = fr.read(new char[5]);
        System.out.println(read);
    }

    /**
     * 一个字符一个字符地写入
     *
     * @param fr
     * @throws IOException
     */
    public void readCharOneByOne(FileReader fr) throws IOException {
        char[] buffer = new char[5];
        int tmp;
        int len = 0;
        while ((tmp = fr.read(buffer)) != -1) {
            buffer[len] = (char) tmp;
            System.out.println(new String(buffer));
            len++;
        }
    }

    /**
     * 按照字符数组写入
     *
     * @param fr
     * @throws IOException
     */
    public void readCharByCharArray(FileReader fr) throws IOException {
        char[] buffer = new char[5];
        int tmp;
        int len = 0;
        while ((tmp = fr.read(buffer)) != -1) {
            buffer[len] = (char) tmp;
            System.out.println(new String(buffer));
        }
    }

}
