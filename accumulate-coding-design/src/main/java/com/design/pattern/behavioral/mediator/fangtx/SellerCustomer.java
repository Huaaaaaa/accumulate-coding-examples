package com.design.pattern.behavioral.mediator.fangtx;

/**
 * @Author: Huaaaaaa
 * @DateTime: 2021/2/20  10:05
 * @Description: 卖方，具体的同事类，实现抽象方法，即自己的业务逻辑
 */
public class SellerCustomer extends Customer {

    public SellerCustomer(String name) {
        super(name);
        ClientWindow(100, 100);
    }
    /**
     * 卖方发送消息
     *
     * @param message
     */
    @Override
    public void send(String message) {
        ReceiveArea.append("我(卖方)说: " + message + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
        medium.relay(name, message);
    }

    /**
     * 卖方接收消息
     *
     * @param from
     * @param message
     */
    @Override
    public void receive(String from, String message) {
        ReceiveArea.append(from + "说: " + message + "\n");
        //使滚动条滚动到最底端
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
    }
}
