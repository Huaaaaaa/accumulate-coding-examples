package com.accumulate.coding.web.handler;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface ToolHandler {

    Mono<ServerResponse> addOrder(ServerRequest request);

    Mono<ServerResponse> updateOrder(ServerRequest request);

    Mono<ServerResponse> deleteOrder(ServerRequest request);

    Mono<ServerResponse> orderList(ServerRequest request);
}
