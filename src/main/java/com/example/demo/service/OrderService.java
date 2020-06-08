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
    public boolean updateByPrimaryKey(Order order)
    {
        return orderMapper.updateByPrimaryKey(order);
    }
    public List<Order> selectAll()
    {
        return orderMapper.selectAll();
    }
    public List<Order> selectByOrderState(Integer order_state) {
        return orderMapper.selectByOrderState(order_state);
    }

}

