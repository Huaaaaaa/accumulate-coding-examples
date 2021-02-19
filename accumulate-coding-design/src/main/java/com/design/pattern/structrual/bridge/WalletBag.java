package com.design.pattern.structrual.bridge;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/14
 * Todo: 钱包实现
 * Time 10:47
 */
public class WalletBag extends AbstractBag {

    @Override
    String getStyle() {
        System.out.println("钱包");
        return bagColor.getColor()+"Wallet";
    }
}
