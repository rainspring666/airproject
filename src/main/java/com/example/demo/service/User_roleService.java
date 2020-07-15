package com.example.demo.service;

import com.example.demo.entity.User_role;
import com.example.demo.mapper.User_roleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_roleService {

    @Autowired
    private User_roleMapper user_roleMapper;

    List<User_role> get_all_user_role(){
        return user_roleMapper.get_all_user_role_info();
    }

    boolean add_user_role(User_role user_role){
        return user_roleMapper.add_user_role_info(user_role);
    }

    boolean update_user_role(User_role user_role){
        return user_roleMapper.update_user_role_info(user_role);
    }
}
