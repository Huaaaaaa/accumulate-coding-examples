package com.accumulate.coding.tool.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *@ClassName MyBatisConfig
 *@Description TODO
 *@Date 2020/9/11  15:09
 */
/*
@Configuration
@EnableTransactionManagement
public class MyBatisConfig {

    public static final Integer MAX_PAGE_SIZE = 1000;
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 100 条，-1 不受限制
        paginationInterceptor.setLimit(MAX_PAGE_SIZE);
        return paginationInterceptor;
    }
}
*/
