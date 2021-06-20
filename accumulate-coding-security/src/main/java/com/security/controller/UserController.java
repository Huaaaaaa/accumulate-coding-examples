package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: cyhua
 * @createTime: 2021/6/19
 * @description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String userInfo(){
        return "I am user info page.";
    }
}
