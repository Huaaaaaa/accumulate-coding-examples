package com.design.pattern.behavioral.command;

/**
 * @Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo:  增加空调温度命令，聚合空调命令接受者
 * Time 18:58
 */
public class HeatUpAirCommand implements AiCommand {

    private AirConditionerReceiver airReceiver;

    public HeatUpAirCommand(AirConditionerReceiver airReceiver) {
        this.airReceiver = airReceiver;
    }

    /**
     * 执行增加空调温度空调命令
     */
    @Override
    public void execute() {
        System.out.println("增加空调温度命令开始执行....");
        airReceiver.heatUp();
    }

    /**
     * 执行撤销命令，即降低空调温度
     */
    @Override
    public void undo() {
        System.out.println("撤销增加空调温度命令开始执行....");
        airReceiver.collDown();
    }
}
