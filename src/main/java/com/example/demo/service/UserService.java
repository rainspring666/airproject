package com.example.demo.service;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id){
        return userMapper.Sel(id);
    }
    /*

     */
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

}
