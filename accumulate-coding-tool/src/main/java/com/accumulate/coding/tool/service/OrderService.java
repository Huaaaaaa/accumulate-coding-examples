package com.accumulate.coding.tool.service;

import com.accumulate.coding.common.resp.BaseResponse;
import com.accumulate.coding.tool.dao.Order;
import com.accumulate.coding.tool.entity.OrderEntity;

import java.util.List;

/**
 * @ClassName OrderService
 * @Description
 * @Date 2020/8/30  17:37
 */
public interface OrderService {

    BaseResponse<Boolean> createOrder(OrderEntity orderEntity);

    BaseResponse<Boolean> deleteOrder(String orderNumber);

    BaseResponse<Boolean> updateOrder(Order order);

    BaseResponse<List<Order>> gerOrders(String userName);

    BaseResponse<OrderEntity> getOrderDetails(String orderNumber);


}
