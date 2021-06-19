package com.coding.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: cyhua
 * @createTime: 2021/6/19
 * @description:
 */
public interface MenuService {

    boolean canAccess(HttpServletRequest request, Authentication authentication);
}
