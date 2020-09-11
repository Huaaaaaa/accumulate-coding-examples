package com.accumulate.coding.tool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *@ClassName SwaggerConfig
 *@Description 基于官方的配置，无法将配置定义在配置文件中
 *@Date 2020/9/11  15:52
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Value("${swagger.base-package}")
    private String basePackage;

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.version}")
    private String version;

    @Value("${swagger.contact.name}")
    private String concatName;

    @Value("${swagger.contact.url}")
    private String concatUrl;

    @Value("${swagger.contact.email}")
    private String concatEmail;

    @Value("${swagger.serviceUrl}")
    private String serviceUrl;


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(new Contact(concatName, concatUrl, concatEmail))
                .termsOfServiceUrl(serviceUrl)
                .version(version)
                .build();
    }

}
