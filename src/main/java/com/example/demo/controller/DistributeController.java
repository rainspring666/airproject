package com.example.demo.controller;

import com.example.demo.service.OrderService;
import com.example.demo.tools.MyJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/paidan")
public class DistributeController {
    @Autowired
    private OrderService orderService;


    Logger logger = LoggerFactory.getLogger(getClass());
    //登录login


    //展示所有订单

    //展示单个订单详情---核验订单


    //给订单分配操作员--分发


    //x修改订单


    //创建流程---录入




}
