package com.coding.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/6/19
 * @description: 自定义授权失败之后的跳转页，前后端分离时使用，如跳转至error.html
 */
public class MyAuthFailureHandler implements AuthenticationFailureHandler {

    private String url;

    public MyAuthFailureHandler(String url) {
        this.url = url;
    }


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.sendRedirect(url);
    }
}
