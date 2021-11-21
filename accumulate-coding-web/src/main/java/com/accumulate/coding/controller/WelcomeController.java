package com.accumulate.coding.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cyhua
 * @createTime: 2021/11/21
 * @description:
 */
@RestController
public class WelcomeController {

    @GetMapping("/welcome")
    @ResponseBody
    public String index() {
        return "welcome to my app";
    }
}
