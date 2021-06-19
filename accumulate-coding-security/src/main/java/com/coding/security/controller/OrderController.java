package com.coding.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author: cyhua
 * @createTime: 2021/6/19
 * @description:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping("/list")
    @ResponseBody
    public List<String> orderList(){
        return Collections.singletonList("订单1");
    }
}
