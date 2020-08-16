package com.example.demo.mapper;

import com.example.demo.entity.User_role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_roleMapper {
    List<User_role> get_all_user_role_info();

    boolean add_user_role_info(User_role user_role);

    boolean update_user_role_info(User_role user_role);

    boolean del_user_role(String user_id);
}
