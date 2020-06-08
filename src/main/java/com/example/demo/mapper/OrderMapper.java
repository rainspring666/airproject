package com.example.demo.mapper;

import com.example.demo.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    boolean deleteByPrimaryKey(String order_id);

    boolean insert(Order record);

    Order selectByPrimaryKey(String order_id);

    List<Order> selectAll();

    boolean updateByPrimaryKey(Order record);

    List<Order> selectByUserId(String user_id);

    List<Order> selectByOrderState(Integer order_state);

}