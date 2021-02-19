package com.design.pattern.behavioral.command;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo:  开空调命令，聚合空调命令接受者
 * Time 18:58
 */
public class OpenAirCommand implements AiCommand {

    private AirConditionerReceiver airReceiver;

    public OpenAirCommand(AirConditionerReceiver airReceiver) {
        this.airReceiver = airReceiver;
    }

    /**
     * 执行开空调命令
     */
    @Override
    public void execute() {
        System.out.println("开空调命令开始执行....");
        airReceiver.openAir();
    }

    /**
     * 执行撤销命令，即关空调
     */
    @Override
    public void undo() {
        System.out.println("关空调撤销命令开始执行....");
        airReceiver.closeAir();
    }
}
