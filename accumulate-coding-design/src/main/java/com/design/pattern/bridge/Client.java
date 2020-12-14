package com.design.pattern.bridge;

import com.design.api.IBaiDuApi;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/14
 * Todo:
 * Time 16:10
 */
public class Client {

    public static void main(String[] args) {
        BagSeller bs = new BagSeller();
        AbstractBag bag = new WalletBag();
        IBagColor color = new RedBag();
        bag.setBagColor(color);
        bs.produceBag(bag);
    }
}
