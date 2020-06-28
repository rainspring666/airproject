package com.example.demo.mapper;

import com.example.demo.entity.Operator;
import com.example.demo.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface OperatorMapper {
    Operator wx_login_operator(String phone,String pwd);

    boolean wx_bind(String id,String openid);

    boolean bg_add_operator(Operator operator);

    List<Order> wx_show_orders(String op_id);

    List<Operator> all_op_info();

    Operator selectByOpID(String op_id);

}
