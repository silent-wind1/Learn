package com.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
@EnableOpenApi // 开启Swagger2
public class SwaggerConfig {
//    配置了swagger的Docket的bean实例
//    enable是否启动swagger，如果false，则swagger不能在浏览器中访问
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.swagger.controller"))
                .paths(PathSelectors.ant("/swagger/**"))
                .build();
    }

//    配置swagger信息 = apiInfo()
    private ApiInfo apiInfo() {
//        作者信息
        Contact contact = new Contact("叶枫", "https://user.qzone.qq.com/1797719651/infocenter", "1797719651@qq.com");
        return new ApiInfo("Api Documentation",
                "Api Documentation",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
