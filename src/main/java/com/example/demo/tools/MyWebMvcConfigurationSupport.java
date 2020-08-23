package com.example.demo.tools;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

// 拦截器配置类
@Configuration
public class MyWebMvcConfigurationSupport implements WebMvcConfigurer  {
    private MyInterceptor interceptor = new MyInterceptor();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        registry.addInterceptor(interceptor)
                .addPathPatterns("/api/bg/**","/admin/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 当访问根路径时，如http://localhost:8080/  跳转到登录界面  ！！！如无此需求将此方法体中的代码删除即可！！！
        registry.addViewController("").setViewName("page/login");
    }

    /*@Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器
        registry.addInterceptor(interceptor)
                .addPathPatterns("/**","")
                .excludePathPatterns("");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源拦截

        super.addResourceHandlers(registry);
    }

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("login");
        super.addViewControllers(registry);
    }*/
}
