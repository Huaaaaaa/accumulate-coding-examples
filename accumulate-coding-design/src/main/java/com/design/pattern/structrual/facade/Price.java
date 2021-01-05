package com.design.pattern.structrual.facade;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 子系统2：查价类
 * Time 9:06
 */
public class Price {

    private static final Map priceMap = new HashMap();

    static {
        priceMap.put("1", new BigDecimal(20));
        priceMap.put("2", new BigDecimal(10));
        priceMap.put("3", new BigDecimal(30));
        priceMap.put("4", new BigDecimal(300));
        priceMap.put("5", new BigDecimal(2000));
        priceMap.put("6", new BigDecimal(2330));
    }

    public BigDecimal getActualPrice(String goodsId) {
        BigDecimal singlePrice = (BigDecimal) priceMap.get(goodsId);
        return singlePrice != null ? singlePrice : BigDecimal.valueOf(0);
    }
}
