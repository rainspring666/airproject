package com.example.demo.service;

import com.example.demo.entity.Order;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

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


    public boolean order_change_by_id(Order order){
        return orderMapper.order_change_by_id(order);
    }

    public List<Order> searchByMultiConditions(String order_id,String connect_name,String phone, String order_state) {

        if(order_state.equals("")){
            return orderMapper.searchByMultiConditions(order_id, connect_name, phone);
        }

        return orderMapper.searchByMultiConditionsWithState(order_id, connect_name, phone, Integer.parseInt(order_state));

        // //JPA 多条件查询，尚未排序，仅供测试
        // List<Order> result = orderMapper.findAll(new Specification<Order>() {
        //     @Override
        //     public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        //         List<Predicate> list = new ArrayList<Predicate>();
        //
        //         if(!order_id.equals(""))
        //             list.add(cb.equal(root.get("order_id"),order_id));
        //         if(!connect_name.equals(""))
        //             list.add(cb.equal(root.get("order_connect"),connect_name));
        //         if(!phone.equals(""))
        //             list.add(cb.equal(root.get("order_phone"),phone));
        //
        //         Predicate[] p = new Predicate[list.size()];
        //         return cb.and(list.toArray(p));
        //     }
        //
        // });
        //
        // return result;
    }

    public boolean updateOrder_modelf(Order order){
        return orderMapper.updateOrder_modelf(order.getOrder_id(), order.getOrder_modelf());
    }
}

