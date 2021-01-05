package com.design.pattern.creational.builder;

import com.accumulate.coding.common.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/12
 * Todo: 用户调用购买接口购买
 * Time 23:13
 */
@Slf4j
public class Client {

    public static void main(String[] args) {
        BuyDirector bd =new BuyDirector();
        Order order = bd.buy("一杯茶","MacbookPro-202008882438");
        log.info(JsonUtil.toJsonString(order));
    }
}
