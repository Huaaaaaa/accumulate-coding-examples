package com.accumulate.coding.service.impl;

import com.accumulate.coding.service.MenuService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/6/19
 * @description:
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Override
    public boolean canAccess(HttpServletRequest request, Authentication authentication) {
        //获取主体
        Object principal = authentication.getPrincipal();
        //判断主体是否是UserDetails
        if(principal instanceof UserDetails){
            //获取权限
            UserDetails userDetails = (UserDetails) principal;
            Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
            //判断权限
            String requestURI = request.getRequestURI();
            System.out.println("requestURI="+requestURI);
            return authorities.contains(new SimpleGrantedAuthority(requestURI));

        }
        return false;
    }
}
