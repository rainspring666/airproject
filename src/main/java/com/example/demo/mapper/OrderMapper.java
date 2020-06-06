package com.example.demo.mapper;

import com.example.demo.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    boolean deleteByPrimaryKey(String orderId);

    boolean insert(Order record);

    Order selectByPrimaryKey(String orderId);

    List<Order> selectAll();

    boolean updateByPrimaryKey(Order record);

    List<Order> selectByUserId(String userId);

    List<Order> selectByOrderState(Integer orderState);

}