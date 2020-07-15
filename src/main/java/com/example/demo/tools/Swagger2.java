package com.example.demo.tools;

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
 * @author mhh
 * @date 2020/7/15
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
     * 访问：http://localhost:8080/swagger-ui.html 即可查看接口文档
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any()).build();
    }

    /**
     * 构建 api文档的信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题
                .title("空气检测项目后端api接口文档")
                // 设置联系人
                .contact(new Contact("whut", "http://www.baidu.com", "1781521696@163.com"))
                // 描述
                .description("欢迎访问接口文档，这里是描述信息")
                // 定义版本号
                .version("1.0").build();
    }
}