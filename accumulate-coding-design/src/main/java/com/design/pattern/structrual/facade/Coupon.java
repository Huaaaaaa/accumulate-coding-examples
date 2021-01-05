package com.design.pattern.structrual.facade;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 子系统3：优惠券类
 * Time 9:11
 */

@Data
public class Coupon {

    private static final Map<String, List<Double>> couponMap = new HashMap();

    static {
        couponMap.put("user1", Arrays.asList(20.00, 30.00, 50.00));
        couponMap.put("user2", Arrays.asList(200.00, 300.00, 500.00));
        couponMap.put("user3", Arrays.asList(10.00, 30.00, 50.00));
        couponMap.put("user4", Arrays.asList(100.00, 30.00, 50.00));
        couponMap.put("user5", Arrays.asList(50.00, 30.00, 50.00));
    }

    public BigDecimal getCouponPrice(String user) {
        List<Double> coupons = couponMap.get(user);
        BigDecimal totalPrice = new BigDecimal(0);
        if (!CollectionUtils.isEmpty(coupons)) {
            for (Double price : coupons) {
                totalPrice = totalPrice.add(BigDecimal.valueOf(price));
            }
        }
        return totalPrice;
    }
}
