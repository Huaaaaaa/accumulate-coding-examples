package com.design.pattern.behavioral.iterator;

import javafx.scene.control.CustomMenuItem;
import lombok.extern.slf4j.Slf4j;

import java.io.PipedInputStream;
import java.util.Scanner;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/1/30  21:32
 * Description: 客户端使用迭代器
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("请输入Title：");
        String title = new Scanner(System.in).next();
        System.out.println("请输入Description：");
        String desc = new Scanner(System.in).next();
        System.out.println("title：" + title + "----desc：" + desc);
        PictureService ps = new PictureServiceImpl();
        System.out.println("开始添加照片");
        for (int i = 0; i < 6; i++) {
            Picture pi = new Picture(title + i, "第" + i + "张照片" + desc);
            boolean res = ps.add(pi);
            System.out.println(res ? i + "成功" : i + "失败");
        }

        boolean res = confirmInput("查看第一张照片");
        if (!res) return;
        System.out.println("开始获取第一张照片......");
        CustomIterator ci = ps.getPictureIterator();
        Picture first = ci.first();
        System.out.println("第一张照片：" + first.toString());

        boolean res1 = confirmInput("查看最后一张照片");
        if (!res1) return;
        System.out.println("开始获取最后一张照片......");
        Picture last = ci.last();
        System.out.println("最后一张照片：" + last.toString());

        boolean res3 = confirmInput("往前看");
        if (!res3) return;
        System.out.println("开始往前看......");
        boolean has = true;
        Picture previous = null;
        while ((previous = ci.previous()) != null) {
            System.out.println("前一张：" + previous.toString());
            previous = null;
        }
        System.out.println("没有了！！！");

        boolean res2 = confirmInput("往后看");
        if (!res2) return;
        System.out.println("开始往后看......");
        while (ci.hasNext()) {
            Picture next = ci.next();
            System.out.println("下一张：" + next.toString());
        }
        System.out.println("没有了！！！");


        boolean res4 = confirmInput("删除照片");
        if (!res4) return;
        System.out.println("开始删除照片......");
        System.out.println("请输入要删除的照片Title：");
        String delTitle = new Scanner(System.in).next();
        while (ci.hasNext()) {
            Picture next = ci.next();
            if (next.getTitle().equals(delTitle)) {
                ps.remove(next);
                break;
            }
        }


    }


    private static boolean confirmInput(String confirmInfo) {
        System.out.println("是否确认" + confirmInfo + "?");
        String confirmLast = new Scanner(System.in).next();
        if (!confirmLast.equals("1")) {
            System.out.println("输入错误！！");
            return false;
        }
        return true;
    }

}
