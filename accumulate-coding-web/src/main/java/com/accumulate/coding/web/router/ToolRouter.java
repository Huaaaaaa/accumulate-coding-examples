package com.accumulate.coding.web.router;

import com.accumulate.coding.web.handler.ToolHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import javax.annotation.Resource;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ToolRouter {

    @Resource
    private ToolHandler toolUserHandler;

    @Bean
    public RouterFunction<ServerResponse> toolRouterFunction(){
        return route()
                .GET("/tool", accept(MediaType.APPLICATION_JSON), toolUserHandler::orderList)
                .build();
    }
}
