package com.example.demo.service;


import com.example.demo.entity.User_info;
import com.example.demo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    List<User_info> get_all_user_info(){
        return userInfoMapper.get_all_user_info();
    }

    boolean update_user_info(User_info user_info){
        return userInfoMapper.update_user_info(user_info);
    }

    boolean add_user_info(User_info user_info){
        return userInfoMapper.add_user_info(user_info);
    }
}
