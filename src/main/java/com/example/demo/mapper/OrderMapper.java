package com.example.demo.mapper;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    //extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order>
    boolean deleteByPrimaryKey(String order_id);

    boolean insert(Order record);

    Order selectByPrimaryKey(String order_id);

    List<Order> selectAll();

    boolean updateOpByPrimaryKey(String order_id,String op_id);

    List<Order> selectByUserId(String user_id);

    List<Order> selectByOrderState(Integer order_state);

    boolean order_change_by_id(Order order);

    List<Order> searchByMultiConditions(String order_id,String connect_name,String phone);

    boolean updateOrder_modelf(String order_id, String order_modelf);

}