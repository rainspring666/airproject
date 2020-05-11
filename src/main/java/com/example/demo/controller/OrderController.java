package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.Tool;
import com.sun.xml.bind.v2.runtime.reflect.opt.TransducedAccessor_field_Boolean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author mhh
 * @date 2020/3/31
 */
@RestController
@RequestMapping("/api/order")
public class OrderController
{
    @Autowired
    private  Tool tools;

    @Autowired
    private OrderService orderService;

    @PostMapping(value ="/add")
    @ResponseBody
    public MyJsonResult addOrder(@RequestBody Order order,HttpServletRequest request) {

        //String user_id = request.getSession().getAttribute("userid").toString();

        System.out.println("order:"+order.toString());
        System.out.println("add sessionid:"+request.getSession().getId());
        //创建订单id
        order.setOrderId(tools.createOrderId());
        order.setOrderState(0);
        order.setUserId("1");
        order.setOpId("1");
        order.setEvaluationId("1");
        order.setOrderCost((float)100.9);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        order.setOrderCreatetime(dateString);
        //暂时不分配操作员
        //费用计算方式

        System.out.println("order add:"+order.toString());

        if(orderService.insert(order)){
            return MyJsonResult.buildData("ok");
        }
        return MyJsonResult.errorMsg("add order error");
    }

    @GetMapping("/check_detail")
    @ResponseBody
    public MyJsonResult checkByOrder(@RequestParam("order_id") String orderId,
                                     HttpServletRequest request){
        Order order = orderService.selectByPrimaryKey(orderId);
        if(null != order){
            return MyJsonResult.buildData(order);
        }
        return MyJsonResult.errorMsg("not found");
    }


    @RequestMapping(value ="/delete")
    @ResponseBody
    public MyJsonResult deleteOrder(@RequestParam("order_id") String orderId,HttpServletRequest request) {
        if(orderService.deleteByPrimaryKey(orderId)){
            return MyJsonResult.buildData("ok");
        }
        return MyJsonResult.errorMsg("delete order error");
    }


    @RequestMapping(value ="/show_my_orders")
    @ResponseBody
    public JSONArray searchOrderByUserId(HttpServletRequest request) {
        String userId = request.getSession().getAttribute("openid").toString();
        List<Order> orders = orderService.selectByUserId(userId);
        return JSONArray.parseArray(JSON.toJSONString(orders));
    }
    @RequestMapping(value ="/update")
    public MyJsonResult updateOrder(@RequestBody Order order)
    {
        //更新那些东西还没确定啊 先不写的
        if(orderService.updateByPrimaryKey(order))
        {
            return MyJsonResult.buildData("ok");
        }
        return MyJsonResult.errorMsg("update order error");
    }

    //这个函数暂时无用
    @RequestMapping(value = "/All")
    public MyJsonResult selectAllOrder()
    {
        List<Order> orders = orderService.selectAll();
        if (!orders.isEmpty()){
            return MyJsonResult.buildData(orders);
        }
        return MyJsonResult.errorMsg("no order");
    }

    @RequestMapping("/upload_pictures")
    @ResponseBody
    public MyJsonResult upload(HttpServletRequest request,
                               @RequestParam(value = "file", required = false) MultipartFile file) {
        String path = null;
        try {
            request.setCharacterEncoding("UTF-8");
            System.out.println("upload_pictures session："+request.getSession().getId());
            //String user_id = request.getSession().getAttribute("userid").toString();

            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                System.out.println("fileName："+fileName);

                String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                if (type != null) {
                    if ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                        // 自定义的文件名称 以后还要加上orderid 区分多张图片
                        String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                        // 设置存放图片文件的路径
                        path = tools.UPLOAD_PICTURE_PATH  + trueFileName;
                        File dir = new File(tools.UPLOAD_PICTURE_PATH);
                        if (!dir.exists()) {
                            dir.mkdir();
                        }
                        file.transferTo(new File(path));
                    } else {
                        return MyJsonResult.errorMsg("文件类型错误");
                    }
                } else {
                    return MyJsonResult.errorMsg("文件类型空");
                }
            } else {
                return MyJsonResult.errorMsg("貌似你的图片上传失败了呢");
            }
        } catch (IOException e){
            System.out.println("图片上传这里有异常");
        }
        return MyJsonResult.buildData(path);//成功的话 返回图片在服务器的路径 暂时只能一张图片
    }

}
