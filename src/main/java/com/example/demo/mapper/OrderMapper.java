package com.example.demo.mapper;

import com.example.demo.entity.Order;
import java.util.List;

public interface OrderMapper {
    boolean deleteByPrimaryKey(String orderId);

    boolean insert(Order record);

    Order selectByPrimaryKey(String orderId);

    List<Order> selectAll();

    boolean updateByPrimaryKey(Order record);

    List<Order> selectByUserId(String userId);
}