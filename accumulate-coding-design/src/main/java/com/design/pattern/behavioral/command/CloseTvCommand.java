package com.design.pattern.behavioral.command;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo: 关电视命令，聚合电视命令接受者
 * Time 18:43
 */
public class CloseTvCommand implements AiCommand{

    private TvReceiver tvReceiver;

    public CloseTvCommand(TvReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    /**
     * 执行关电视命令
     */
    @Override
    public void execute() {
        System.out.println("关电视命令开始执行....");
        tvReceiver.closeTv();
    }

    /**
     * 执行撤销命令，即开电视
     */
    @Override
    public void undo() {
        System.out.println("关电视撤销命令开始执行....");
        tvReceiver.openTv();
    }
}
