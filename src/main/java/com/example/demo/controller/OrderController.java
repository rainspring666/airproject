package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Operator;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.mapper.ProcessMapper;
import com.example.demo.service.OperatorService;
import com.example.demo.service.OrderService;
import com.example.demo.tools.*;
import com.sun.rowset.internal.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    private ProcessMapper processMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 用户新增一条订单记录
     * @param order
     * @param request
     * @return 是否成功
     */
    @PostMapping(value ="/add")
    @ResponseBody
    public MyJsonResult addOrder(@RequestBody Order order,HttpServletRequest request) {

        String user_id = request.getSession().getAttribute("userid").toString();
        //创建订单id
        order.setOrder_id(tools.createOrderId());
        order.setOrder_state("0");
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
        logger.info("add order error");
        return MyJsonResult.errorMsg("add order error");
    }

    /**
     * 小程序根据order_id检查一条记录的详细信息
     * @param order_id
     * @param request
     * @return 成功则是订单记录的详细信息
     */
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

    /**
     * 小程序删除一条订单记录
     * @param orderId
     * @param request
     * @return 是否成功
     */
    @RequestMapping(value ="/delete")
    @ResponseBody
    public MyJsonResult deleteOrder(@RequestParam("order_id") String orderId,HttpServletRequest request) {
        if(orderService.deleteByPrimaryKey(orderId)){
            logger.info("delete an order："+orderId);
            return MyJsonResult.buildData("ok");
        }
        return MyJsonResult.errorMsg("delete order error");
    }

    /**
     * 小程序用户显示自己的全部订单记录
     * @param request
     * @return 列表
     */
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

    /**
     * web端显示数据库所有订单记录----是否使用？？？ 未使用
     * @return
     */
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
     *  按照订单的状态查询订单———————是否使用？？？ 未使用
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

    /**
     * 小程序端 订单户型图上传
     * @param request
     * @param file
     * @return
     */
    @RequestMapping("/upload_pictures")
    @ResponseBody
    public MyJsonResult upload(HttpServletRequest request,
                               @RequestParam(value = "file", required = false) MultipartFile file) {
        String user_id = request.getSession().getAttribute("userid").toString();
        String path = null, imgDir = "hx_img";
        try {
            request.setCharacterEncoding("UTF-8");
            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
                if (type != null) {
                    if ("PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {

                        /*// 自定义的文件名称 以后还要加上orderid 区分多张图片
                        String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                        // 设置存放图片文件的路径
                        path = tools.UPLOAD_PICTURE_PATH  + trueFileName;*/

                        // 自定义的文件名称使用UUID
                        String trueFileName = tools.createOrderId() + "." + type;
                        Calendar calendar = Calendar.getInstance();
                        // 设置存放图片文件的路径    hx_img/年/月/日/图片   考虑是否去掉年份？？？？

                        String temp =  imgDir + "/" + Integer.toString(calendar.get(calendar.YEAR)) + "/"
                                + Integer.toString(calendar.get(calendar.MONTH)+1) + "/"+ Integer.toString(calendar.get(calendar.DAY_OF_MONTH)) + "/";

                        path = temp  + trueFileName;
                        File dir = new File(tools.UPLOAD_PICTURE_PATH +temp);
                        //Process process = processMapper.
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        file.transferTo(new File(tools.UPLOAD_PICTURE_PATH +path));

                        // 路径之间以@分割
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
        logger.info("user {} upload picture:{}",user_id,path + "@");
        return MyJsonResult.buildData(path + "@");//成功的话 返回图片在服务器的路径 暂时只能一张图片
    }

    // 小程序端订单信息显示图片
    @GetMapping("/show_pic")
    @ResponseBody
    public JSONArray show_order_pices(HttpServletRequest request,@RequestParam("order_id") String order_id){
        Order order = orderService.selectByPrimaryKey(order_id);
        String order_modelf = order.getOrder_modelf();

        System.out.println(order_modelf);
        // 以@分隔开
        String[] result = order_modelf.split("@");
        logger.info("小程序请求订单图片");
        for (int i= 0; i < result.length; i++)
            System.out.println(result[i]);
        return JSONArray.parseArray(JSON.toJSONString(result));
    }
}
