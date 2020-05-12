package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User Sel(int id);
    User login_user(String phone, String pwd);
    boolean save_user(User user);
    User finduserphone(String phone);
    User getuserbyopenid(String openid);
    boolean update_info(String id,String name,int gender)
;}
