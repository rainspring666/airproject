package com.example.demo.mapper;

import com.example.demo.entity.User_info;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapper {

    List<User_info> get_all_user_info();

    User_info get_user_info_by_id(String user_id);

    boolean add_user_info(User_info user_info);

    boolean update_user_info(User_info user_info);

    boolean del_user_info(String user_id);
}
