package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Equipment;
import com.example.demo.entity.Material;
import com.example.demo.entity.Order;
import com.example.demo.service.OperatorService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.OrderClassEnum;
import com.example.demo.tools.OrderStateEnum;
import com.example.demo.tools.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

/*
后台管理页面跳转
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private OperatorService operatorService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private Tool tools;

    //主页index
    @RequestMapping("/index.html")
    public String demo(){
        logger.info("layuimini_index.html");
        return "index";
    }
    @RequestMapping("/page/welcome-1.html")
    public String welcome1(){
        logger.info("page/welcome-1.html");
        return "page/welcome-1.html";
    }
    @RequestMapping("/page/welcome-2.html")
    public String welcome2(){
        logger.info("page/welcome-2.html");
        return "page/welcome-2.html";
    }
    @RequestMapping("/page/welcome-3.html")
    public String welcome3(){
        logger.info("page/welcome-3.html");
        return "page/welcome-3.html";
    }
    @RequestMapping("/page/menu.html")
    public String menu(){
        logger.info("/page/menu.html");
        return "page/menu.html";
    }
    @RequestMapping("/page/setting.html")
    public String setting(){
        logger.info("/page/setting.html");
        return "page/setting.html";
    }
    @RequestMapping("/page/table.html")
    public String table(){
        logger.info("/page/table.html");
        return "page/table.html";
    }
    @RequestMapping("/page/form.html")
    public String form(){
        logger.info("/page/form.html");
        return "page/form.html";
    }
    @RequestMapping("/page/form-step.html")
    public String form_step(){
        logger.info("/page/form-step.html");
        return "page/form-step.html";
    }
    @RequestMapping("/page/login-1.html")
    public String login1(){
        logger.info("/page/login-1.html");
        return "page/login-1.html";
    }
    @RequestMapping("/page/login-2.html")
    public String login2(){
        logger.info("/page/login-2.html");
        return "page/login-2.html";
    }
    @RequestMapping("/page/404.html")
    public String page404(){
        logger.info("/page/404.html");
        return "page/404.html";
    }
    @RequestMapping("/page/button.html")
    public String button(){
        logger.info("/page/button.html");
        return "page/button.html";
    }
    @RequestMapping("/page/layer.html")
    public String layer(){
        logger.info("/page/layer.html");
        return "page/layer.html";
    }
    @RequestMapping("/page/icon.html")
    public String icon(){
        logger.info("/page/icon.html");
        return "page/icon.html";
    }
    @RequestMapping("/page/icon-picker.html")
    public String icon_picker(){
        logger.info("/page/icon-picker.html");
        return "page/icon-picker.html";
    }
    @RequestMapping("/page/color-select.html")
    public String color_select(){
        logger.info("/page/color-select.html");
        return "page/color-select.html";
    }
    @RequestMapping("/page/table-select.html")
    public String table_select(){
        logger.info("/page/table-select.html");
        return "page/table-select.html";
    }
    @RequestMapping("/page/upload.html")
    public String upload(){
        logger.info("/page/upload.html");
        return "page/upload.html";
    }
    @RequestMapping("/page/editor.html")
    public String editor(){
        logger.info("/page/editor.html");
        return "page/editor.html";
    }
    @RequestMapping("/page/area.html")
    public String area(){
        logger.info("/page/area.html");
        return "page/area.html";
    }
    //page/button.html?v=1
    //page/button.html?v=2"



    @RequestMapping("/page/error.html")
    public String error(){
        logger.info("/page/error.html");
        return "page/error.html";
    }
    @RequestMapping("/page/distribute.html")
    public String distribute(){
        logger.info("/page/distribute.html");
        return "page/distribute.html";
    }
    @RequestMapping("/page/home_page.html")
    public String homePage(){
        logger.info("/page/home_page.html");
        return "page/home_page.html";
    }
    @RequestMapping("/page/info_statistical.html")
    public String info_statistical(){
        logger.info("/page/info_statistical.html");
        return "page/info_statistical.html";
    }
    @RequestMapping("/page/order_info.html")
    public String order_info(){
        logger.info("/page/order_info.html");
        return "page/order_info.html";
    }
    @RequestMapping("/page/process_info.html")
    public String process_info(){
        logger.info("/page/process_info.html");
        return "page/process_info.html";
    }
    @RequestMapping("/page/user_info.html")
    public String user_info(){
        logger.info("/page/user_info.html");
        return "page/user_info.html";
    }

    @GetMapping("/page/table/dis_process")
    public String dis_process(@RequestParam("orderID") String order_id , Model model){
        logger.info("/page/table/dis_process.html");
        Order order = orderService.selectByPrimaryKey(order_id);
        // order.setUser_id(userService.selectByUserID(order.getUser_id()).getUser_name());//更换姓名
        order.setUser_id(userInfoService.get_user_info_by_id(order.getUser_id()).getUser_name());//更换姓名

        order.setOp_id(operatorService.selectByOpID(order.getOp_id()).getOp_name());
        order.setOrder_class(OrderClassEnum.getName(order.getOrder_class()));
        order.setOrder_state(OrderStateEnum.getName(Integer.parseInt(order.getOrder_state())));
        logger.info(order.toString());
        model.addAttribute("order",order);
        return "page/table/dis_process";
    }

    @GetMapping ("/page/table/order_detail")
    public String order_detail(@RequestParam("order") String strOrder, Model model){
        logger.info("/page/table/order_detail.html");
        //
        JSONObject jsonOrder = (JSONObject) JSONObject.parse(strOrder);
        Order order = jsonOrder.toJavaObject(Order.class);
        logger.info(order.toString());
        model.addAttribute("order",order);
        return "page/table/order_detail";
    }

    @GetMapping ("/page/table/material_detail")
    public String material_detail(@RequestParam("material") String strOrder, Model model){
        logger.info("/page/table/material_detail.html");
        //
        JSONObject jsonOrder = (JSONObject) JSONObject.parse(strOrder);
        Material material = jsonOrder.toJavaObject(Material.class);
        logger.info(material.toString());
        model.addAttribute("material",material);
        return "page/table/material_detail";
    }

    @GetMapping ("/page/table/material_edit")
    public String material_edit(@RequestParam("material") String strOrder, Model model){
        logger.info("/page/table/material_edit.html");
        //
        JSONObject jsonOrder = (JSONObject) JSONObject.parse(strOrder);
        Material material = jsonOrder.toJavaObject(Material.class);
        logger.info(material.toString());
        model.addAttribute("material",material);
        return "page/table/material_edit";
    }

    @GetMapping ("/page/table/material_add.html")
    public String material_add( Model model){
        logger.info("/page/table/material_add.html");
        //

        return "page/table/material_add";
    }

    @GetMapping ("/page/table/equipment_edit")
    public String equipment_edit(@RequestParam("equipment") String strOrder, Model model){
        logger.info("/page/table/equipment_edit.html");
        //
        System.out.println(strOrder);
        JSONObject jsonOrder = (JSONObject) JSONObject.parse(strOrder);
        Equipment equipment = jsonOrder.toJavaObject(Equipment.class);
        logger.info(equipment.toString());
        model.addAttribute("equipment",equipment);
        return "page/table/equipment_edit";
    }

    @GetMapping ("/page/table/equipment_detail")
    public String equipment_detail(@RequestParam("equipment") String strOrder, Model model){
        logger.info("/page/table/equipment_detail.html");
        //
        System.out.println(strOrder);
        JSONObject jsonOrder = (JSONObject) JSONObject.parse(strOrder);
        Equipment equipment = jsonOrder.toJavaObject(Equipment.class);
        logger.info(equipment.toString());
        model.addAttribute("equipment",equipment);
        return "page/table/equipment_detail";
    }

    @GetMapping ("/page/table/equipment_add.html")
    public String equipment_add( Model model){
        logger.info("/page/table/equipment_add.html");
        //

        return "page/table/equipment_add";
    }

    @GetMapping ("/page/table/order_add.html")
    public String order_add( Model model){
        logger.info("/page/table/order_add.html");
        //

        return "page/table/order_add";
    }
    @GetMapping ("/page/table/order_edit.html")
    public String order_edit(@RequestParam("order") String strOrder, Model model){
        logger.info("/page/table/order_edit.html");
        //
        JSONObject jsonOrder = (JSONObject) JSONObject.parse(strOrder);
        Order order = jsonOrder.toJavaObject(Order.class);
        logger.info(order.toString());
        model.addAttribute("order",order);
        return "page/table/order_edit";
    }

    @RequestMapping("api/upload")
    @ResponseBody
    public   MyJsonResult webFileUpload(HttpServletRequest request, @RequestParam("orderID") String order_id ,@RequestParam(value = "file") MultipartFile file){
        try {
            logger.info(order_id);
            String path= tools.UPLOAD_PICTURE_PATH;
            String fileName = file.getOriginalFilename();
            String  suffix = fileName.substring(fileName.lastIndexOf("."));
            String newFileName =	UUID.randomUUID().toString() + suffix;
            File targetFile = new File(path, newFileName);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
            logger.info("图片上传成功"+targetFile.getAbsolutePath());
            return MyJsonResult.buildData("上传成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  MyJsonResult.errorMsg("上传失败");
    }


}
