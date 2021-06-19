package com.coding.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author: cyhua
 * @createTime: 2021/6/12
 * @description:
 */
@Controller
public class LoginController {

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public String login(String userName,String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        return userDetails == null ? "redirect:login.html" : "/index";
    }

    @PostMapping("/toIndex")
    public String index(){
        return "redirect:index.html";
    }

    @PostMapping("/toError")
    public String error(){
        return "redirect:error.html";
    }
}