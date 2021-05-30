package com.accumulate.coding.tool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName SecurityConfig
 * @Description TODO
 * @Date 2020/9/11  16:14
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**",
            "/index"
    };

    /**
     * PasswordEncoder
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 通过 inMemoryAuthentication 来开启在内存中定义用户，withUser 中是用户名，password 中则是用户密码，roles 中是用户角色。
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("hyc").password("hyc123").roles("admin");
    }


    /**
     * web.ignoring() 用来配置忽略掉的 URL 地址，一般对于静态文件，我们可以采用此操作。
     *
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    /**
     * 如果我们使用 XML 来配置 Spring Security ，里边会有一个重要的标签 <http>，HttpSecurity 提供的配置方法 都对应了该标签。
     *
     * @param http
     * @throws Exception
     * @AuthorizeRequests 对应了 <intercept-url>。
     * formLogin 对应了 <formlogin>。
     * and 方法表示结束当前标签，上下文回到HttpSecurity，开启新一轮的配置。
     * permitAll 表示登录相关的页面/接口不要被拦截。
     * 最后记得关闭 csrf ，关于 csrf 问题我到后面专门和大家说。
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login.html").loginProcessingUrl("/doLogin").permitAll()
                .and().csrf().disable();
    }
}
