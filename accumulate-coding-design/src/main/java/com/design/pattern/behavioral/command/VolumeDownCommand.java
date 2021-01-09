package com.design.pattern.behavioral.command;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo:  减小电视音量命令，聚合电视命令接受者
 * Time 18:48
 */
public class VolumeDownCommand implements AiCommand{


    private TvReceiver tvReceiver;

    public VolumeDownCommand(TvReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    /**
     * 执行减小电视音量命令
     */
    @Override
    public void execute() {
        System.out.println("减小电视音量命令开始执行....");
        tvReceiver.volumeDown();
    }

    /**
     * 执行撤销命令，即增加音量
     */
    @Override
    public void undo() {
        System.out.println("减小电视音量撤销命令开始执行....");
        tvReceiver.volumeUp();
    }
}
