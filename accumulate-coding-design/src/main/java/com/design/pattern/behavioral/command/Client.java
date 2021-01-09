package com.design.pattern.behavioral.command;

import org.checkerframework.checker.units.qual.A;

import java.rmi.Remote;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo: 客户端开始调用
 * Time 19:31
 */
public class Client {

    public static void main(String[] args) {

        /**
         *  开始发起命令
         */
        RemoteController rc = new RemoteController();
        rc.onButtonWasPushed(0);
        rc.onButtonWasPushed(1);
        rc.onButtonWasPushed(2);
        rc.onButtonWasPushed(3);
        rc.onButtonWasPushed(4);
        rc.onButtonWasPushed(5);
        rc.onButtonWasPushed(6);
        rc.onButtonWasPushed(7);
        rc.onButtonWasPushed(8);
        rc.onButtonWasPushed(9);
    }

}
