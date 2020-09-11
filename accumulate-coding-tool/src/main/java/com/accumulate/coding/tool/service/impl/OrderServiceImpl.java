package com.accumulate.coding.tool.service.impl;

import com.accumulate.coding.common.resp.BaseResponse;
import com.accumulate.coding.tool.dao.Order;
import com.accumulate.coding.tool.entity.OrderEntity;
import com.accumulate.coding.tool.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
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

    private ParameterizedTypeReference<BaseResponse<List<Order>>> orderListTypeReference =
            new ParameterizedTypeReference<BaseResponse<List<Order>>>() {
    };

    /**
     * create order
     *
     * @param orderEntity
     * @return
     */
    @Override
    public BaseResponse<Boolean> createOrder(OrderEntity orderEntity) {
        validateParam(orderEntity, "orderEntity");
//        int res = orderMapper.insert(OrderDataMapper.INSTANCE.entityToOrder(orderEntity));
        return new BaseResponse<>(false);
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
//        int res = orderMapper.delete(OrderWrapper.getOrderNumberWrapper(orderNumber));
        return new BaseResponse<>(1 > 0);
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
//        int res = orderMapper.update(order, OrderWrapper.getOrderNumberWrapper(order.getOrderNumber()));
        return new BaseResponse<>(1 > 0);
    }


    /**
     * get order list by userName
     *
     * @param userName
     * @return
     */
    @Override
    public BaseResponse<List<Order>> gerOrders(String userName) {
//        validateParam(userName, "userName");
//        List<Order> orders = orderMapper.selectList(OrderWrapper.getUserNameWrapper(userName));
        return new BaseResponse<>(null);
    }


    /**
     * get order details by orderNumber
     *
     * @param orderNumber
     * @return
     */
    @Override
    public BaseResponse<OrderEntity> getOrderDetails(String orderNumber) {
//        validateParam(orderNumber, "orderNumber");
//        Order order = orderMapper.selectOne(OrderWrapper.getOrderNumberWrapper(orderNumber));
//        OrderEntity orderEntity = OrderDataMapper.INSTANCE.orderToEntity(order);
        return new BaseResponse<>(null);

    }

}
