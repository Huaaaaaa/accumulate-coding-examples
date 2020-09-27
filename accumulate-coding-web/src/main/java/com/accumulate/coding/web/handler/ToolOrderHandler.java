package com.accumulate.coding.web.handler;

import com.accumulate.coding.tool.dao.Order;
import com.accumulate.coding.tool.request.CreateOrderReq;
import com.accumulate.coding.tool.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Service("toolOrderHandler")
public class ToolOrderHandler implements ToolHandler {

    @Resource
    private OrderService orderServiceImpl;

    @Override
    public Mono<ServerResponse> addOrder(ServerRequest request) {
        return request.bodyToMono(CreateOrderReq.class).map(createOrderReq -> orderServiceImpl.createOrder(createOrderReq.getOrderEntity())).flatMap(baseResponse -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(baseResponse));
    }

    @Override
    public Mono<ServerResponse> updateOrder(ServerRequest request) {
        return request.bodyToMono(Order.class).map(order -> orderServiceImpl.updateOrder(order)).flatMap(baseResponse -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(baseResponse));
    }

    @Override
    public Mono<ServerResponse> deleteOrder(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> orderList(ServerRequest request) {
        return null;
    }
}