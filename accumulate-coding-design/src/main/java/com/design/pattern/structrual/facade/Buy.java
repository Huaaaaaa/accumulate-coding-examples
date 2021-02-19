package com.design.pattern.structrual.facade;

import java.math.BigDecimal;

/**
 * @Author: Huaaaaaa
 * Date:  2020/12/27
 * Todo: 外观类：buy
 * desc: 外观类依赖三个子系统完成下单、查价、校验价格、查优惠信息等流程，最后返回给客户最终的订单信息，包含应该支付的价格，而无需自己调用相关系统的接口进行查询
 * Time 9:23
 */
public class Buy {

    private Order order = new Order();

    private Price price = new Price();

    private Coupon coupon = new Coupon();


    public OrderDetail buy(String userName, Goods goods, int quantity) throws Exception {
        //1、调用子系统Order下单
        OrderDetail orderDetail = order.createOrder(userName, goods, quantity);
        //2、调用子系统Price查价
        BigDecimal singlePrice = price.getActualPrice(goods.getGoodId());
        //校验价格是否正确
        BigDecimal goodsPrice = goods.getPrice();
        if (singlePrice == null) {
            throw new Exception("没有找到相应的价格");
        }
        if (goodsPrice == null) {
            goodsPrice = singlePrice;
        }
        if (!goodsPrice.equals(singlePrice)) {
            throw new Exception("价格不正确");
        }
        //计算总价格
        BigDecimal totalPrice = singlePrice.multiply(BigDecimal.valueOf(quantity));
        orderDetail.setTotalPrice(totalPrice);
        //3、调用子系统Coupon查询优惠券价格
        BigDecimal couponPrice = coupon.getCouponPrice(userName);
        if (couponPrice.compareTo(totalPrice) >= 0) {
            couponPrice = totalPrice;
            orderDetail.setActualPrice(BigDecimal.valueOf(0));
        } else {
            orderDetail.setActualPrice(totalPrice.subtract(couponPrice));
        }
        orderDetail.setCouponPrice(couponPrice);

        return orderDetail;
    }
}
