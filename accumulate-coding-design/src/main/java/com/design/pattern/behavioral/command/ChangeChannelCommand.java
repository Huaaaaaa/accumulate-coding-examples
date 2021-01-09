package com.design.pattern.behavioral.command;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo:  换频道命令，聚合电视命令接受者
 * Time 18:50
 */
public class ChangeChannelCommand implements AiCommand {

    private TvReceiver tvReceiver;

    public ChangeChannelCommand(TvReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    /**
     * 执行换频道电视命令
     */
    @Override
    public void execute() {
        System.out.println("电视换频道命令开始执行....");
        tvReceiver.changeChannel(1);
    }

    /**
     * 执行撤销命令，减频道
     */
    @Override
    public void undo() {
        System.out.println("关电视换频道撤销命令开始执行....");
        tvReceiver.changeChannel(0);
    }
}
