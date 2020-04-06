package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import com.example.demo.tools.JsonResult;
import com.example.demo.tools.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    Tool tools  = new Tool();
    @Autowired
    private OrderService orderService;

    @RequestMapping(value ="/add")
    public JsonResult addOrder(@RequestBody Order order) {
        // 设置订单号
        order.setOrderId(tools.createOrderId());
        // 创建订单生成时间
        order.setOrderCreatetime(new Date());
        if(orderService.insert(order)){
            return JsonResult.buildData(order);
        }
        return JsonResult.errorMsg("add order error");
    }
    @RequestMapping(value ="/delete")
    public JsonResult deleteOrder(String orderId) {
        System.out.println(orderId);
        if(orderService.deleteByPrimaryKey(orderId)){
            return JsonResult.buildData("ok");
        }
        return JsonResult.errorMsg("delete order error");
    }

    @RequestMapping(value ="/search/byOrderId")
    public JsonResult searchOrderByOrderId(String orderId) {
        Order order = orderService.selectByPrimaryKey(orderId);
        if(null != order){
            return JsonResult.buildData(order);
        }
        return JsonResult.errorMsg("not found");
    }

    @RequestMapping(value ="/search/byUserId")
    public JsonResult searchOrderByUserId(String userId) {
        List<Order> orders = orderService.selectByUserId(userId);
        if(!orders.isEmpty()){
            return JsonResult.buildData(orders);
        }
        return JsonResult.errorMsg("not found");
    }
    @RequestMapping(value ="/update")
    public JsonResult updateOrder(@RequestBody Order order)
    {
        if(orderService.updateByPrimaryKey(order))
        {
            return JsonResult.buildData("ok");
        }
        return JsonResult.errorMsg("update order error");
    }
    @RequestMapping(value = "/All")
    public JsonResult selectAllOrder()
    {
        List<Order> orders = orderService.selectAll();
        if (!orders.isEmpty()){
            return JsonResult.buildData(orders);
        }
        return JsonResult.errorMsg("no order");
    }

}
