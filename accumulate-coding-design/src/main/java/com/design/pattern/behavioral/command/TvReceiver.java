package com.design.pattern.behavioral.command;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo: 电视命令接受者
 * Time 18:37
 */
public class TvReceiver {


    /**
     * 开电视
     */
    public void openTv() {
        System.out.println("电视打开");
    }

    /**
     * 关电视
     */
    public void closeTv() {
        System.out.println("电视关闭");
    }

    /**
     * 开电视
     */
    public void changeChannel(int type) {
        if (type == 1) {
            System.out.println("加频道");
        } else {
            System.out.println("减频道");
        }

    }

    /**
     * 开电视
     */
    public void volumeUp() {
        System.out.println("加大音量");
    }

    /**
     * 开电视
     */
    public void volumeDown() {
        System.out.println("减小音量");
    }
}
