package com.design.pattern.structrual.flyweight;

import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo:
 * Time 13:57
 */
@Slf4j
public class Client {

    public static void main(String[] args) {
        try {
            File file1 = PokerFactory.getPokerCard("红桃", 1);
            File file2 = PokerFactory.getPokerCard("红桃", 1);
            //打印两张扑克的hashcode，发现是一样的，这样就实现了一个享元模式
            System.out.println("file1=" + file1.hashCode() + "\r\n" + "file2=" + file2.hashCode());
            getPic(file1);
            getPic(file2);
//            getPic(PokerFactory.getPokerCard("梅花", 11));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void getPic(File file) {
        Image image = null;

        try {
            image = ImageIO.read(file);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        JFrame frame = new JFrame();
        JLabel label = new JLabel(new ImageIcon(image));
        label.setText(file.getName());
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        //关闭窗口--退出调试
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
