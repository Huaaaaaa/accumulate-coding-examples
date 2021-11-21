package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/6/12
 * @description:
 */
@Controller
public class LoginController {

    @Resource
    private UserDetailsService myUserServiceImpl;

    @PostMapping("/login")
    public String login(String userName, String password) {
        UserDetails userDetails = myUserServiceImpl.loadUserByUsername(userName);
        return userDetails == null ? "redirect:login.html" : "/index";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/toIndex")
    public String index() {
        return "redirect:index.html";
    }

    @PostMapping("/toError")
    public String error() {
        return "redirect:error.html";
    }
}
