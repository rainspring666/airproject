package com.example.demo.controller;

import com.example.demo.tools.MyJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/bg/admin")
public class AdminController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @RequestMapping("/index.html")
    public String login(){
        logger.info("admin");
        return "distributer";
    }
}
