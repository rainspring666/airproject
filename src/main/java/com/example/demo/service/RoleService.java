package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    List<Role> get_all_role(){
        return roleMapper.get_all_role();
    }

    boolean add_role(Role role){
        return roleMapper.add_role(role);
    }

    boolean update_role_info(Role role){
        return roleMapper.update_role_info(role);
    }
}
