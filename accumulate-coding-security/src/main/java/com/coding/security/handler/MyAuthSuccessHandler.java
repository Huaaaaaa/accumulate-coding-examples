package com.coding.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/6/19
 * @description: 自定义授权成功之后的跳转页，前后端分离时使用，如跳转至http://www.baidu.com
 */
public class MyAuthSuccessHandler implements AuthenticationSuccessHandler {

    private String url;

    public MyAuthSuccessHandler(String url) {
        this.url = url;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        User user = (User) authentication.getPrincipal();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getAuthorities());
        System.out.println(request.getRemoteAddr());
        response.sendRedirect(url);
    }
}
