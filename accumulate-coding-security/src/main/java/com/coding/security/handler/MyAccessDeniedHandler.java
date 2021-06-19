package com.coding.security.handler;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: cyhua
 * @createTime: 2021/6/19
 * @description: 拒绝访问页面
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        PrintWriter writer = response.getWriter();
        response.setHeader("Content-Type","application/json;charset=UTF-8");
        writer.write("{\"status\":\"error\",\"msg\":\"对不起，您无权访问，请联系管理员\"}");
        writer.flush();
        writer.close();
    }
}
