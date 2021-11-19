package com.coding.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: cyhua
 * @createTime: 2021/6/12
 * @description:
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //private MyAccessDeniedHandler myAccessDeniedHandler;

    /**
     * 自定义登录页面的配置
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        //自定义登录页
        httpSecurity.formLogin()
                //自定义登录参数
                .usernameParameter("userName")
                .passwordParameter("password")
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                //登录成功后的跳转逻辑
                .successForwardUrl("/toIndex")
                //登录成功后的跳转逻辑-自定义登录成功处理器handler
//                .successHandler(new MyAuthSuccessHandler("/toIndex"))
                //登录失败后的跳转逻辑
                .failureForwardUrl("/toError");
        //登录失败后的跳转逻辑-自定义登录失败处理器handler
//                .failureHandler(new MyAuthFailureHandler("/toError"));
        //授权
        httpSecurity.authorizeRequests()
                //放行错误页，不需要认证
                .antMatchers("/error.html").permitAll()
                //放行静态资源
                .antMatchers("/css/**", "/js/**", "/images/**", "/html/**").permitAll()
                //正则匹配
                .regexMatchers("/health").permitAll()
                //正则匹配同时指定请求方式
                .regexMatchers(HttpMethod.POST, "/health").permitAll()
                .mvcMatchers("/health").servletPath("").permitAll()
                //放行登录页，不需要认证
                .antMatchers("/login.html").permitAll()
                //基于权限的访问控制:严格区分大小写
//                .antMatchers("/user/**").hasAnyAuthority("admin")
                //等价于上面的写法
                .antMatchers("/user/**").access("hasAnyAuthority('admin')")
                //基于角色的访问控制：严格区分大小写
//                .antMatchers("/order/**").hasAnyRole("USER","ADMIN")
                //等价于上面的写法
                .antMatchers("/order/**").access("hasAnyRole('USER','ADMIN')")
                //基于IP的访问控制
                .antMatchers("/**").hasIpAddress("127.0.0.1")
                //其他请求都要进行认证
//                .anyRequest().authenticated()
                .anyRequest().access("@menuServiceImpl.canAccess(httpServletRequest,authentication)");

        //禁用csrf
        httpSecurity.csrf().disable();

        //异常处理
        //httpSecurity.exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
