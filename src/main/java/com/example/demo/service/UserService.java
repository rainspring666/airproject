package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User login_user(String user_phone, String user_pwd){
        return userMapper.login_user(user_phone,user_pwd);
    }

    public boolean save_user(User user)
    {
        if(userMapper.save_user(user))
            return true;
        return false;

    }

    public boolean findUserPhone(String phone)
    {
        if(userMapper.finduserphone(phone)!=null)
            return true;
        return false;
    }

    public User getUserByOpenid(String id){
        return userMapper.getuserbyopenid(id);
    }

    public boolean update_info(String id,String name,int gender){
        return userMapper.update_info(id,name,gender);
    }

    public User selectByUserID(String userId){
        return userMapper.selectByUserID(userId);
    }

    public List<User> selectAllUser(int role_id){
        return userMapper.selectAllUser(role_id);
    }

    public List<User> selectUserByParams(String user_id,String user_name,String user_phone, int kind){
        return userMapper.selectUserByParams(user_id, user_name, user_phone, kind);
    }

    public boolean del_user(String user_id){
        return userMapper.del_user(user_id);
    }

    public boolean reset_user(String user_id){
        return userMapper.reset_user(user_id);
    }
}
