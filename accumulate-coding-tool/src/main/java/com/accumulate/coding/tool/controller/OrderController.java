package com.accumulate.coding.tool.controller;

import com.accumulate.coding.common.controller.BaseController;
import com.accumulate.coding.common.resp.BaseApiResponse;
import com.accumulate.coding.common.resp.BaseResponse;
import com.accumulate.coding.tool.dao.Order;
import com.accumulate.coding.tool.entity.OrderEntity;
import com.accumulate.coding.tool.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Date 2020/8/30  22:29
 */
@RestController("/order")
@Slf4j
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    /**
     * create order
     *
     * @param orderEntity
     * @return
     */
    @PostMapping("/create")
    public BaseApiResponse<Boolean> createOrder(OrderEntity orderEntity) {
        BaseResponse<Boolean> response = orderService.createOrder(orderEntity);
        return baseApiResponse(response, "");
    }

    /**
     * get order list with userName
     *
     * @param userName
     * @return
     */
    @GetMapping("/gerOrders/{userName}")
    public BaseApiResponse<List<Order>> getOrderWithUser(@PathVariable String userName) {
        BaseResponse<List<Order>> response = orderService.gerOrders(userName);
        return baseApiResponse(response, "");
    }

    /**
     * update order with orderNumber
     *
     * @param order
     * @return
     */
    @PutMapping("/updateOrder")
    public BaseApiResponse<List<Order>> updateOrder(Order order) {
        BaseResponse<Boolean> response = orderService.updateOrder(order);
        return baseApiResponse(response, "");
    }

    /**
     * delete order with orderNumber
     *
     * @param orderNumber
     * @return
     */
    @DeleteMapping("/delete/orderNumber")
    public BaseApiResponse<Boolean> deleteOrder(@PathVariable String orderNumber) {
        BaseResponse<Boolean> response = orderService.deleteOrder(orderNumber);
        return baseApiResponse(response, "");
    }

}
