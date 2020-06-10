package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/bg/admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/index.html")
    public String login(){
        logger.info("admin");
        return "admin";
    }
    @RequestMapping("/order/distribute.html")
    public String distribute(){
        logger.info("admin");
        return "distribute";
    }
    @RequestMapping("/order/detail.html")
    public String detail(){
        logger.info("admin");
        return "detail";
    }
}
