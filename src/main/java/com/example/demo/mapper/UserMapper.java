package com.example.demo.mapper;


import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User Sel(int id);
    User login_user(String phone, String pwd);
    boolean save_user(User user);
    User findusernickname(String name);
    User finduserphone(String phone);
}
