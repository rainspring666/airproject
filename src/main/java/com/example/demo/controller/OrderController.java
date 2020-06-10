package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Operator;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.service.OperatorService;
import com.example.demo.service.OrderService;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.OrderClassEnum;
import com.example.demo.tools.OrderStateEnum;
import com.example.demo.tools.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

    @Autowired
    private OperatorService operatorService;

    Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping(value ="/add")
    @ResponseBody
    public MyJsonResult addOrder(@RequestBody Order order,HttpServletRequest request) {

        String user_id = request.getSession().getAttribute("userid").toString();
        //创建订单id
        order.setOrder_id(tools.createOrderId());
        order.setOrder_state(0);
        order.setUser_id(user_id);
        order.setOp_id("1");//默认操作员-待分配
        order.setOrder_cost((float)100.9); //费用计算方式

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        order.setOrder_createtime(dateString);

        if(orderService.insert(order)){
            logger.info("add an order："+order.toString());
            return MyJsonResult.buildData("ok");
        }
        return MyJsonResult.errorMsg("add order error");
    }

    @GetMapping("/check_detail")
    @ResponseBody
    public MyJsonResult checkByOrder(@RequestParam("order_id") String order_id,
                                     HttpServletRequest request){
        Order order = orderService.selectByPrimaryKey(order_id);
        if(null != order){
            return MyJsonResult.buildData(order);
        }
        return MyJsonResult.errorMsg("not found");
    }


    @RequestMapping(value ="/delete")
    @ResponseBody
    public MyJsonResult deleteOrder(@RequestParam("order_id") String orderId,HttpServletRequest request) {
        if(orderService.deleteByPrimaryKey(orderId)){
            logger.info("delete an order："+orderId);
            return MyJsonResult.buildData("ok");
        }
        return MyJsonResult.errorMsg("delete order error");
    }


    @GetMapping(value ="/show_my_orders")
    @ResponseBody
    public JSONArray searchOrderByUserId(HttpServletRequest request) {
        User myuser = (User) request.getSession().getAttribute("myuser");
        String userId = myuser.getUser_id();
        List<Order> orders = orderService.selectByUserId(userId);

        //组装操作员信息
        List<Operator> op_list = operatorService.all_op_info();
        HashMap<String, String> op_map=new HashMap<String,String>();
        for(int i=0;i<op_list.size();i++){
            Operator operator = op_list.get(i);
            op_map.put(operator.getOp_id(),operator.getOp_name());
        }
        //组装给前端显示的信息
        for(int i=0;i<orders.size();i++){
            Order order = orders.get(i);
            order.setOrder_class(OrderClassEnum.getName(order.getOrder_class()));
            order.setOp_id(op_map.get(order.getOp_id()));
        }
        logger.info("user:{} 's orders，共:{}条",userId,orders.size());
        return JSONArray.parseArray(JSON.toJSONString(orders));
    }

    @RequestMapping(value = "/all")
    public MyJsonResult selectAllOrder()
    {
        List<Order> orders = orderService.selectAll();

        /*组装响应数据  start  便于前端显示*/
        List<Operator> op_list = operatorService.all_op_info();

        // 获得Op_id----------->Op_name
        HashMap<String, String> op_map = new HashMap<String,String>();
        for (Operator operator : op_list) {
            op_map.put(operator.getOp_id(), operator.getOp_name());
        }

        // 组装Json数据
        int total = orders.size();
        JSONArray item = JSONArray.parseArray(JSON.toJSONString(orders));
        // 调整返回数据
        JSONObject tempJsonObject = null;
        for(int i=0;i<item.size();i++) {
            tempJsonObject = item.getJSONObject(i);
            // 组装操作员信息
            String opId = tempJsonObject.getString("op_id");
            tempJsonObject.fluentPut("op_id",op_map.get(opId));
            // 组装订单类别信息
            String orderClass = tempJsonObject.getString("order_class");
            tempJsonObject.fluentPut("order_class",OrderClassEnum.getName(orderClass));
            // 组装订单状态信息
            Integer orderState = tempJsonObject.getInteger("order_state");
            tempJsonObject.fluentPut("order_state", OrderStateEnum.getName(orderState));
        }


        JSONObject data = new JSONObject();
        data.put("total",total);
        data.put("item",item);

        if (!orders.isEmpty()){
            return MyJsonResult.build(0,"msg",data);
        }
        return MyJsonResult.errorMsg("no order");
    }


    /**
     *  按照订单的状态查询订单
     * @param id 参数范围以及意义：订单状态：0----未处理; 1------处理中; 2----完成
     * @return jsonResult
     *
     */
    @RequestMapping(value = "/orderState")
    public MyJsonResult selectByOrderState(Integer id)
    {
        List<Order> orders = orderService.selectByOrderState(id);

        /*组装响应数据  start  便于前端显示*/
        List<Operator> op_list = operatorService.all_op_info();
        // 组装操作员数据
        HashMap<String, String> op_map = new HashMap<String,String>();
        for (Operator operator : op_list) {
            op_map.put(operator.getOp_id(), operator.getOp_name());
        }

        JSONArray item = JSONArray.parseArray(JSON.toJSONString(orders));
        // 调整返回数据
        JSONObject tempJsonObject = null;
        for(int i=0;i<item.size();i++) {
            tempJsonObject = item.getJSONObject(i);
            // 组装操作员信息
            String opId = tempJsonObject.getString("op_id");
            tempJsonObject.fluentPut("op_id",op_map.get(opId));
            // 组装订单类别信息
            String orderClass = tempJsonObject.getString("order_class");
            tempJsonObject.fluentPut("order_class",OrderClassEnum.getName(orderClass));
            // 组装订单状态信息
            Integer orderState = tempJsonObject.getInteger("order_state");
            tempJsonObject.fluentPut("order_state", OrderStateEnum.getName(orderState));
        }
        if (!orders.isEmpty()){
            return MyJsonResult.buildData(item);
        }
        return MyJsonResult.errorMsg("no order");
    }

    @RequestMapping("/upload_pictures")
    @ResponseBody
    public MyJsonResult upload(HttpServletRequest request,
                               @RequestParam(value = "file", required = false) MultipartFile file) {
        String user_id = request.getSession().getAttribute("userid").toString();
        String path = null;
        try {
            request.setCharacterEncoding("UTF-8");
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
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
        logger.info("user {} upload picture:{}",user_id,path);
        return MyJsonResult.buildData(path);//成功的话 返回图片在服务器的路径 暂时只能一张图片
    }

}
