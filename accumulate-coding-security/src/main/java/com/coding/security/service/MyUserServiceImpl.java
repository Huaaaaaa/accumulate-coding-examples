package com.coding.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author: Huaaaaaa
 * @createTime: 2021/6/12
 * @description:
 */
@Service
public class MyUserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //1.根据用户名查询用户，是否存在
        if(!"admin".equals(userName)){
            throw new UsernameNotFoundException("用户不存在");
        }
        //2.校验密码，如果匹配成功则返回UserDetails
        String password = passwordEncoder.encode("123");
        return new User(userName,password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal,ROLE_USER,ROLE_ADMIN"));
    }
}
