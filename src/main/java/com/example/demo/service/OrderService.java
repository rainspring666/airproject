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
    public List<Order> selectByUserId(String userId)
    {
        return orderMapper.selectByUserId(userId);
    }
    public Order selectByPrimaryKey(String orderId)
    {
        return orderMapper.selectByPrimaryKey(orderId);
    }
    public boolean deleteByPrimaryKey(String orderId)
    {
        return orderMapper.deleteByPrimaryKey(orderId);
    }
    public boolean updateByPrimaryKey(Order order)
    {
        return orderMapper.updateByPrimaryKey(order);
    }
    public List<Order> selectAll()
    {
        return orderMapper.selectAll();
    }
    public List<Order> selectByOrderState(Integer orderState)
    {
        return orderMapper.selectByOrderState(orderState);
    }

}

