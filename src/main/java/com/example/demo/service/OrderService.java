package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public boolean insert(Order order)
    {
        return orderMapper.insert(order);
    }
    public List<Order> selectByUserId(String user_id)
    {
        return orderMapper.selectByUserId(user_id);
    }
    public Order selectByPrimaryKey(String order_id)
    {
        return orderMapper.selectByPrimaryKey(order_id);
    }
    public boolean deleteByPrimaryKey(String order_id)
    {
        return orderMapper.deleteByPrimaryKey(order_id);
    }
    public boolean updateOpByPrimaryKey(String order_id,String op_id)
    {
        return orderMapper.updateOpByPrimaryKey(order_id,op_id);
    }
    public List<Order> selectAll()
    {
        return orderMapper.selectAll();
    }
    public List<Order> selectByOrderState(Integer order_state) {
        return orderMapper.selectByOrderState(order_state);
    }

    public boolean updateOrder_modelf(Order order){
        return orderMapper.updateOrder_modelf(order.getOrder_id(), order.getOrder_modelf());
    }
}

