package com.example.demo.tools;


import com.example.demo.entity.Admin;
import com.sun.java.swing.plaf.windows.resources.windows;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.slf4j.Logger;

/*
*初步查看，后台端的代码使用的接口均为api/bg/*以及admin/*,对这两类接口进行拦截
* */

public class MyInterceptor implements HandlerInterceptor { // 自定义拦截器

    Logger logger = LoggerFactory.getLogger(getClass());

    // 该数组存放着派单员可以被放行的uri，如果传入的参数包含数组中的某一个就可以被放行，可以进行添加
    private String[] URI = {
            "getallorderinfo","page/distribute.html","page/table/dis_process","order/search",
            "page/table/order_detail","page/table/order_edit","page/table/report_add","getalloperatorinfo",
            "api/upload","distribute_index","page/home_page","admin/lay/modules/form.js",
    };

    // 该函数用来判断派单员是否可以放行
    private boolean distributorPass(String uri){


        // 放行物料、设备的界面
        if(uri.contains("material") || uri.contains("equipment") || uri.contains("editor") || uri.contains("upload"))
            return true;
        // 循环遍历URI数组，是否包括
        for (String i: URI) {
            if(i.equals("distribute_index")){
                if(uri.contains("distribute_index") && !uri.contains("distribute_index.html#"))
                    return true;
                else
                    continue;
            } else if(uri.contains(i)){
                return true;
            }
        }
        logger.info(uri+"被拦截");
        return false;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 在请求发送过来时执行，可以在此处进行拦截
        String uri = request.getRequestURI();
        logger.info(uri+"进入拦截器");
        if(uri.contains("/login") || uri.contains("/register") || uri.contains("404")){
            //对于登录注册模块一律放行
            return true;
        }

        // 以下处理的uri均需要先登录 未登录的均进行拦截，跳转到登录界面
        Admin admin = (Admin) request.getSession().getAttribute("ADMIN_SESSION");
        if(admin == null){
            try {
                // 重定向到登录界面

                response.sendRedirect("/admin/page/404.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        // 对派单员只放行派单管理界面和物料设备界面用到的uri
        if(admin.getAdmin_role() == 1){
            if(!distributorPass(uri)){
                // 转到404界面
                try {
                    response.sendRedirect("/admin/page/404.html");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
