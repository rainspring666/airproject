package com.example.demo.controller;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Process;
import com.example.demo.service.AdminService;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProcessService;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/distribute")
public class DistributeController {
    @Autowired
    private OrderService orderService;
    @Autowired
    ProcessService processService;
    @Autowired
    private Tool tools;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private AdminService adminService;

    Logger logger = LoggerFactory.getLogger(getClass());
    //登录login
    @PostMapping("/login_distribute")
    @ResponseBody
    public MyJsonResult login(@RequestBody Admin admin){
        String pwdMD5 = tools.pwdMD5(admin.getAdmin_phone().substring(8, 24));
        String admin_phone = admin.getAdmin_phone();
        Admin tempAdmin = adminService.doLoginAdmin(admin_phone, pwdMD5);
        if(tempAdmin != null)
        {
            //注册sessionid
            request.getSession().setMaxInactiveInterval(120*60);//以秒为单位，即在没有活动120分钟后，session将失效
            request.getSession().setAttribute("admin_phone", admin_phone);//用户名存入该用户的session 中
            //request.getSession().setAttribute("openid",open_id);
            String sessionid = request.getSession().getId();
            logger.info("admin {} login:",admin_phone);
            tempAdmin.setAdmin_pwd("");
            return MyJsonResult.build(200,sessionid,tempAdmin);
        }
        logger.info("admin {} login failure：",admin_phone);
        return MyJsonResult.errorMsg("密码错误");
    }


    //展示单个订单详情---核验订单


    //给订单分配操作员--分发
    @PostMapping("/distribute_order")
    @ResponseBody
    public MyJsonResult distributeOrder(String order_id,String user_id,String op_id){
        // 创建process_id
        Process process = new Process();
        String process_id = tools.createOrderId();
        process.setProcess_id(process_id);
        // process表设置user_id和order_id
        process.setOrder_id(order_id);
        process.setUser_id(user_id);

        // 更新数据库
        boolean isUpdateOp = orderService.updateOpByPrimaryKey(order_id, op_id);
        boolean isAddProcess = processService.add_process(process);

        if(isUpdateOp && isAddProcess){
            return MyJsonResult.buildData("ok");
        } else{
            return MyJsonResult.errorMsg("error");
        }
    }

    //x修改订单


    //创建流程---录入




}
