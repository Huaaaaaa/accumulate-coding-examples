package com.coding.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/6/12
 * @description:
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health(){
        return "I'm alive";
    }



}
