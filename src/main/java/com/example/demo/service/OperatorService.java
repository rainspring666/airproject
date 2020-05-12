package com.example.demo.service;

import com.example.demo.entity.Operator;
import com.example.demo.mapper.OperatorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OperatorService {
    OperatorMapper operatorMapper;
    public Operator wx_login_operator(String phone,String pwd){
        return operatorMapper.wx_login_operator(phone,pwd);
    }
    public boolean wx_bind(String id,String openid){
        return operatorMapper.wx_bind(id,openid);
    }
    public boolean bg_add(Operator operator)
    {
        return operatorMapper.bg_add(operator);
    }
    public List<Operator> wx_show_orders(String op_id){
        return operatorMapper.wx_show_orders(op_id);
    }

}
