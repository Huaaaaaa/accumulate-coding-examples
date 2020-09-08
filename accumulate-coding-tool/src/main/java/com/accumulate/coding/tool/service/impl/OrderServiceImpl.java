package com.accumulate.coding.tool.service.impl;

import com.accumulate.coding.common.resp.BaseResponse;
import com.accumulate.coding.tool.dao.Order;
import com.accumulate.coding.tool.entity.OrderEntity;
import com.accumulate.coding.tool.mapper.OrderMapper;
import com.accumulate.coding.tool.mapstruct.mapper.OrderEntityMapper;
import com.accumulate.coding.tool.service.OrderService;
import com.accumulate.coding.tool.wrapper.OrderWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Date 2020/8/30  17:40
 */
@Service
@Slf4j
public class OrderServiceImpl extends BaseService implements OrderService {


    @Autowired
    private OrderMapper orderMapper;

    /**
     * create order
     *
     * @param orderEntity
     * @return
     */
    @Override
    public BaseResponse<Boolean> createOrder(OrderEntity orderEntity) {
        validateParam(orderEntity, "orderEntity");
        int res = orderMapper.insert(OrderEntityMapper.INSTANCE.entityToOrder(orderEntity));
        return new BaseResponse<>(res > 0);
    }

    /**
     * delete order by orderNumber
     *
     * @param orderNumber
     * @return
     */
    @Override
    public BaseResponse<Boolean> deleteOrder(String orderNumber) {
        validateParam(orderNumber, "orderNumber");
        int res = orderMapper.delete(OrderWrapper.getOrderNumberWrapper(orderNumber));
        return new BaseResponse<>(res > 0);
    }

    /**
     * update order
     *
     * @param order
     * @return
     */
    @Override
    public BaseResponse<Boolean> updateOrder(Order order) {
        validateParam(order, "order");
        validateParam(order.getOrderNumber(), "orderNumber");
        int res = orderMapper.update(order, OrderWrapper.getOrderNumberWrapper(order.getOrderNumber()));
        return new BaseResponse<>(res > 0);
    }


    /**
     * get order list by userName
     *
     * @param userName
     * @return
     */
    @Override
    public BaseResponse<List<Order>> gerOrders(String userName) {
        validateParam(userName, "userName");
        List<Order> orders = orderMapper.selectList(OrderWrapper.getUserNameWrapper(userName));
        return new BaseResponse<>(orders);
    }


    /**
     * get order details by orderNumber
     *
     * @param orderNumber
     * @return
     */
    @Override
    public BaseResponse<OrderEntity> getOrderDetails(String orderNumber) {
        return null;
    }


    /**
     * get order list with more information with userName
     *
     * @return
     */
    @Override
    public BaseResponse<List<OrderEntity>> getOrderList(String userName) {
        return null;
    }
}
