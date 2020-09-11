package com.accumulate.coding.tool.config;

import com.accumulate.coding.tool.constants.AppDataSourceConstants;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Date 2020/9/10  18:12
 */
@Configuration
@EnableConfigurationProperties(AppDataSourceConstants.class)
public class DataSourceConfig {

    private AppDataSourceConstants appDataSourceConstants;

    public DataSourceConfig(AppDataSourceConstants appDataSourceConstants) {
        this.appDataSourceConstants = appDataSourceConstants;
    }


    @Bean
    public DataSource dataSource() {
        HikariDataSource datasource = new HikariDataSource();
        datasource.setJdbcUrl(appDataSourceConstants.getUrl());
        datasource.setUsername(appDataSourceConstants.getUserName());
        datasource.setPassword(appDataSourceConstants.getPassword());
        datasource.setDriverClassName(appDataSourceConstants.getDriverClassName());
        datasource.setMinimumIdle(appDataSourceConstants.getMinIdle());
        datasource.setMaximumPoolSize(appDataSourceConstants.getMaxActive());
        datasource.setIdleTimeout(appDataSourceConstants.getMinIdle());
        return datasource;
    }
}
