package com.security.config;

import com.security.handler.MyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author: cyhua
 * @createTime: 2021/6/12
 * @description:
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAccessDeniedHandler myAccessDeniedHandler;

    @Autowired
    private DataSource dataSource;

    @Resource
    private UserDetailsService myUserServiceImpl;

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
        httpSecurity.authorizeRequests().antMatchers("/error.html").permitAll()
                //放行静态资源
                .antMatchers("/css/**", "/js/**", "/images/**", "/html/**").permitAll()
                //正则匹配
                .regexMatchers("/health").permitAll()
                //正则匹配同时指定请求方式
                .regexMatchers(HttpMethod.POST, "/health").permitAll()
                .mvcMatchers("/health").servletPath("").permitAll()
                //放行登录页，不需要认证
                .antMatchers("/login.html").permitAll().and()
                .rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60)   //Token过期时间为1分钟
                .userDetailsService(myUserServiceImpl).and().authorizeRequests()
                //放行错误页，不需要认证

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
        httpSecurity.exceptionHandling().accessDeniedHandler(myAccessDeniedHandler);

        //记住我功能配置
        httpSecurity.rememberMe().tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60)   //Token过期时间为1分钟
                .userDetailsService(myUserServiceImpl).and().authorizeRequests();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        jdbcTokenRepositoryImpl.setDataSource(dataSource);
        //启动时创建一张表，这个参数到第二次启动时必须注释掉，因为已经创建了一张表
//        jdbcTokenRepositoryImpl.setCreateTableOnStartup(true);
        return jdbcTokenRepositoryImpl;
    }
}
