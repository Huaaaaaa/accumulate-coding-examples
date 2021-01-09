package com.design.pattern.behavioral.command;

/**
 * Author: Huaaaaaa
 * Date:  2021/1/9
 * Todo: 命令调用者类：遥控器，需要设置命令
 * Time 19:04
 */
public class RemoteController {


    //奇数:第一列命令
    private static AiCommand[] oddCommands;
    //偶数：第二列命令
    private static AiCommand[] evenCommands;


    /**
     * 初始化命令
     */
    static {

        oddCommands = new AiCommand[6];
        evenCommands = new AiCommand[6];
        int next = 0;
        for (int i = 0; i < 10; i++) {
            if (isOdd(i)) {
                evenCommands[i / 2 + 1] = new NoCommand();
            } else {
                oddCommands[i / 2] = new NoCommand();
            }
        }
        /**
         * 电视命令类
         */
        TvReceiver tvReceiver = new TvReceiver();
        AiCommand tvOpenCommand = new OpenTvCommand(tvReceiver);
        AiCommand tvCloseCommand = new CloseTvCommand(tvReceiver);
        AiCommand tvVolumeUp = new VolumeUpCommand(tvReceiver);
        AiCommand tvVolumeDown = new VolumeDownCommand(tvReceiver);
        AiCommand changeChannel = new ChangeChannelCommand(tvReceiver);

        /**
         * 空调命令类
         */
        AirConditionerReceiver airReceiver = new AirConditionerReceiver();
        AiCommand airOpenCommand = new OpenAirCommand(airReceiver);
        AiCommand airCloseCommand = new CloseAirCommand(airReceiver);
        AiCommand airheadUpCommand = new HeatUpAirCommand(airReceiver);
        AiCommand airCoolDownCommand = new CoolDownAirCommand(airReceiver);

        /**
         *  开始发起命令
         */
        setCommands(0, tvOpenCommand);
        setCommands(1, tvCloseCommand);
        setCommands(2, tvVolumeUp);
        setCommands(3, tvVolumeDown);
        setCommands(4, changeChannel);
        setCommands(5, new NoCommand());
        setCommands(6, airOpenCommand);
        setCommands(7, airCloseCommand);
        setCommands(8, airheadUpCommand);
        setCommands(9, airCoolDownCommand);
    }

    public RemoteController() {
    }

    /**
     * 设置命令
     *
     * @param index
     * @param aiCommand
     */
    private static void setCommands(int index, AiCommand aiCommand) {
        if (isOdd(index)) {
            oddCommands[index / 2 + 1] = aiCommand;
        } else {
            evenCommands[index / 2] = aiCommand;
        }


    }

    public void onButtonWasPushed(int index) {
        if (RemoteController.isOdd(index)) {
            oddCommands[index / 2 + 1].execute();
        } else {
            evenCommands[index / 2].execute();
        }
    }


    private static boolean isOdd(int index) {
        return index % 2 == 0;
    }


}
