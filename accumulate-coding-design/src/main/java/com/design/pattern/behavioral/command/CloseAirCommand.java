package com.design.pattern.behavioral.command;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo:  关空调命令，聚合空调命令接受者
 * Time 18:58
 */
public class CloseAirCommand implements AiCommand {

    private AirConditionerReceiver airReceiver;

    public CloseAirCommand(AirConditionerReceiver airReceiver) {
        this.airReceiver = airReceiver;
    }

    /**
     * 执行关空调命令
     */
    @Override
    public void execute() {
        System.out.println("关空调命令开始执行....");
        airReceiver.closeAir();
    }

    /**
     * 执行撤销命令，即开空调
     */
    @Override
    public void undo() {
        System.out.println("撤销关空调命令开始执行....");
        airReceiver.openAir();
    }
}
