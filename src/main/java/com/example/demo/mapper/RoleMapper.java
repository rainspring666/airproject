package com.example.demo.mapper;

import com.example.demo.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    List<Role> get_all_role();

    boolean add_role(Role role);

    boolean update_role_info(Role role);
}
