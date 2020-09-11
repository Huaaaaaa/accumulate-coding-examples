package com.accumulate.coding.tool.controller;

import com.accumulate.coding.common.resp.BaseApiResponse;
import com.accumulate.coding.common.resp.BaseResponse;
import com.accumulate.coding.tool.dao.Order;
import com.accumulate.coding.tool.entity.OrderEntity;
import com.accumulate.coding.tool.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Date 2020/8/30  22:29
 */
@RestController
@RequestMapping("/order")
@Slf4j
@Api(tags = "订单管理")
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
    @ResponseBody
    @ApiOperation(value = "创建订单")
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
    @ResponseBody
    @ApiOperation(value = "获取用户订单列表")
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
    @ResponseBody
    @ApiOperation(value = "修改订单")
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
    @ResponseBody
    @ApiOperation(value = "删除订单")
    public BaseApiResponse<Boolean> deleteOrder(@PathVariable String orderNumber) {
        BaseResponse<Boolean> response = orderService.deleteOrder(orderNumber);
        return baseApiResponse(response, "");
    }

    /**
     * get orderEntity
     *
     * @param orderNumber
     * @return
     */
    @GetMapping("/delete/orderNumber")
    @ResponseBody
    @ApiOperation(value = "获取用户订单详情")
    public BaseApiResponse<OrderEntity> getOrderEntity(@PathVariable String orderNumber) {
        BaseResponse<OrderEntity> response = orderService.getOrderDetails(orderNumber);
        return baseApiResponse(response, "");
    }

}
