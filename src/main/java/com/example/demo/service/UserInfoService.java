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

    public List<User_info> get_all_user_info(){
        return userInfoMapper.get_all_user_info();
    }

    public User_info get_user_info_by_id(String user_id){
        return userInfoMapper.get_user_info_by_id(user_id);
    }

    public boolean update_user_info(User_info user_info){
        return userInfoMapper.update_user_info(user_info);
    }

    public boolean add_user_info(User_info user_info){
        return userInfoMapper.add_user_info(user_info);
    }

    public boolean del_user_info(String user_id){
        return userInfoMapper.del_user_info(user_id);
    }
}
