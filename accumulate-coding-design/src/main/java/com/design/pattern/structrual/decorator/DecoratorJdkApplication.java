package com.design.pattern.structrual.decorator;

import java.io.*;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/20
 * Todo: 装饰模式在jdk中的应用
 * Time 11:42
 */
public class DecoratorJdkApplication {

    public static void main(String[] args) {
        File file = new File("E://decorator.txt");
        try {
            OutputStream os = new FileOutputStream(file);
            //FilterOutputStream为输出流抽象装饰器
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF("你好！");

            InputStream inputStream = new FileInputStream(file);
            //FilterInputStream为输入流抽象装饰器
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String msg = dataInputStream.readUTF();
            System.out.println("msg=" + msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
