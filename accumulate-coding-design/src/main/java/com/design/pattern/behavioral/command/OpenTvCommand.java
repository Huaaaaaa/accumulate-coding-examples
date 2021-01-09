package com.design.pattern.behavioral.command;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo: 开电视命令，聚合电视命令接受者
 * Time 18:36
 */
public class OpenTvCommand implements AiCommand {

    private TvReceiver tvReceiver;

    public OpenTvCommand(TvReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    /**
     * 执行开电视命令
     */
    @Override
    public void execute() {
        System.out.println("开电视命令开始执行....");
        tvReceiver.openTv();
    }

    /**
     * 执行撤销命令，即关电视
     */
    @Override
    public void undo() {
        System.out.println("开电视撤销命令开始执行....");
        tvReceiver.closeTv();
    }
}
