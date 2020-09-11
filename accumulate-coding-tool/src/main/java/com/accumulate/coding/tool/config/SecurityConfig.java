package com.accumulate.coding.tool.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *@ClassName SecurityConfig
 *@Description TODO
 *@Date 2020/9/11  16:14
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private  static  final  String[]  AUTH_WHITELIST  =  {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };
    @Override
    protected  void  configure(HttpSecurity http)  throws  Exception  {
        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers("/**/*").denyAll();
    }
}
