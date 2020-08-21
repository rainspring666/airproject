package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/bg/admin")
public class AdminLoginController {
    @Autowired
    private Tool tools;
    @Autowired
    private AdminService adminService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/register")
    @ResponseBody
    public MyJsonResult register(HttpServletRequest request){
        String admin_id = tools.createOrderId();
        Admin admin = new Admin();
        admin.setAdmin_id(admin_id);
        admin.setAdmin_name(request.getParameter("admin_name"));
        admin.setAdmin_pwd(request.getParameter("admin_pwd"));
        admin.setAdmin_phone(request.getParameter("admin_phone"));
        admin.setAdmin_role(Integer.parseInt(request.getParameter("admin_role")));
        if(adminService.findAdminByPhone(admin.getAdmin_phone()) != null)
            return MyJsonResult.errorMsg("手机号码重复");
        if(!adminService.addAdmin(admin))
            return MyJsonResult.errorMsg("注册失败");
        logger.info("管理员注册成功"+admin.toString());
        return MyJsonResult.buildData("ok");
    }

    @PostMapping("/login")
    @ResponseBody
    public MyJsonResult login(@RequestBody Admin admin, HttpServletRequest request){
        /*String admin_id = tools.createOrderId();
        Admin admin = new Admin();
        admin.setAdmin_id(admin_id);
        admin.setAdmin_name(request.getParameter("admin_name"));
        admin.setAdmin_pwd(request.getParameter("admin_pwd"));
        admin.setAdmin_phone(request.getParameter("admin_phone"));
        admin.setAdmin_role(Integer.parseInt(request.getParameter("admin_role")));*/
        Admin theAdmin = adminService.findAdminByPhone(admin.getAdmin_phone());
        if(theAdmin == null)
            return MyJsonResult.errorMsg("手机号码还未注册");
        if(theAdmin.getAdmin_pwd().equals(admin.getAdmin_pwd())){
            logger.info(theAdmin.toString());

            // 放入session中作为依据
            request.getSession().setAttribute("ADMIN_SESSION", theAdmin);
            return MyJsonResult.buildData(theAdmin.getAdmin_role());
        }

        return MyJsonResult.errorMsg("密码错误");
    }
}
