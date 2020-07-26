package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Operator;
import com.example.demo.entity.Order;
import com.example.demo.entity.User;
import com.example.demo.entity.User_info;
import com.example.demo.service.OperatorService;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserInfoService;
import com.example.demo.service.UserService;
import com.example.demo.tools.MyJsonResult;
import com.example.demo.tools.OrderClassEnum;
import com.example.demo.tools.OrderStateEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.weaver.ast.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/bg/admin")
public class AdminOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OperatorService operatorService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoService userInfoService;

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 展示所有订单信息，列表，sql查询简单排序
     * @return
     */
    @GetMapping(value = "/order/show_all_order")
    @ResponseBody
    public Map<String,Object> selectAllOrder(@RequestParam(required = false,defaultValue = "1") int page,
                                             @RequestParam(required = false,defaultValue = "15") int limit)
    {
        PageHelper.startPage(page, limit);
        List<Order> orders = orderService.selectAll();

        /*组装响应数据 便于前端显示*/
        List<Operator> op_list = operatorService.all_op_info();
        List<User_info> User_infos = userInfoService.get_all_user_info();

        // 获得Op_id----------->Op_name
        HashMap<String, String> op_map = new HashMap<String,String>();
        for (Operator operator : op_list) {
            op_map.put(operator.getOp_id(), operator.getOp_name());
        }
        HashMap<String, String> user_map = new HashMap<String,String>();
        for (User_info user_info : User_infos) {
            user_map.put(user_info.getUser_id(), user_info.getUser_name());
        }
        for(int i = 0; i < orders.size(); i++){
            Order order = orders.get(i);
            // 组装操作员信息
            String opId = order.getOp_id();
            order.setOp_id(op_map.get(opId));//更换为操作员的名字
            // 组装订单类别信息
            String orderClass = order.getOrder_class();
            order.setOrder_class(OrderClassEnum.getName(orderClass));
            // 组装订单状态信息
            String orderState = order.getOrder_state();
            order.setOrder_state(OrderStateEnum.getName(Integer.parseInt(orderState)));

            String userId = order.getUser_id();
            order.setUser_id(user_map.get(userId));
        }


        PageInfo pageInfo = new PageInfo(orders);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        // return map;

        if (!orders.isEmpty()){
            map.put("msg","操作成功");
            return map;
        }
        map.put("msg","操作失败");
        return map;
    }

    /**
     *web端 新增一条order记录 游客性质的用户 企业用户
     * @return
     */
    @PostMapping("/order/add_one_order")
    @ResponseBody
    public MyJsonResult add_order(@RequestBody Order order){
        //补充order必要的信息
        order.setOrder_state("0");
        order.setOp_id("1");
        order.setUser_id("");//临时用户 游客id====
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        order.setOrder_createtime(dateString);

        if(orderService.insert(order)){
            logger.info("web add an order："+order.getOrder_id());
            return MyJsonResult.buildData("ok");
        }

        return MyJsonResult.errorMsg("后台新增订单记录错误");
    }

    /**
     * 图片上传
     */


    /**
     * web端删除order记录
     * @param order_id
     * @param request
     * @return
     */
    @PostMapping("/order/delete")
    @ResponseBody
    public MyJsonResult delete_order(@RequestParam("chooseOrderID") String order_id,
                                     HttpServletRequest request){
        logger.info("delete"+order_id);
        if(orderService.deleteByPrimaryKey(order_id))
            return MyJsonResult.buildData("ok");

        return MyJsonResult.errorMsg("删除order失败");
    }

    /**
     * web端修改编辑更新order记录信息
     * @return
     */
    @PostMapping("/order/change")
    @ResponseBody
    public MyJsonResult change_order(@RequestBody Order order){

        logger.info(order.toString());
        if(orderService.order_change_by_id(order))
            return MyJsonResult.errorMsg("ok");
        return MyJsonResult.errorMsg("error");
    }

    @GetMapping("/order/search")
    public Map<String,Object> search_order(HttpServletRequest request){

        JSONObject searchParams = JSONObject.parseObject(request.getParameter("searchParams"));
        PageHelper.startPage(1, 20);

        String order_id = searchParams.getString("order_id");
        String phone = searchParams.getString("phone");
        String connect_name = searchParams.getString("connect_name");
        //多条件搜索
        List<Order> orderList = orderService.searchByMultiConditions(order_id,connect_name,phone);

        /*组装响应数据 便于前端显示*/
        List<Operator> op_list = operatorService.all_op_info();
        List<User_info> User_infos = userInfoService.get_all_user_info();

        // 获得Op_id----------->Op_name
        HashMap<String, String> op_map = new HashMap<String,String>();
        for (Operator operator : op_list) {
            op_map.put(operator.getOp_id(), operator.getOp_name());
        }
        HashMap<String, String> user_map = new HashMap<String,String>();
        for (User_info user_info : User_infos) {
            user_map.put(user_info.getUser_id(), user_info.getUser_name());
        }
        for(int i = 0; i < orderList.size(); i++){
            Order order = orderList.get(i);
            // 组装操作员信息
            String opId = order.getOp_id();
            order.setOp_id(op_map.get(opId));//更换为操作员的名字
            // 组装订单类别信息
            String orderClass = order.getOrder_class();
            order.setOrder_class(OrderClassEnum.getName(orderClass));
            // 组装订单状态信息
            String orderState = order.getOrder_state();
            order.setOrder_state(OrderStateEnum.getName(Integer.parseInt(orderState)));

            String userId = order.getUser_id();
            order.setUser_id(user_map.get(userId));
        }

        PageInfo pageInfo = new PageInfo(orderList);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        if (!orderList.isEmpty()){
            map.put("msg","操作成功");
            return map;
        }
        map.put("msg","操作失败");
        return map;
    }

}
