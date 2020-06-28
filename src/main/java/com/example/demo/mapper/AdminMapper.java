package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * @author mhh
 * @date 2020/6/10
 */
@Repository
public interface AdminMapper {
    Admin findAdminById(String admin_id);

    Admin doLoginAdmin(String admin_phone,String admin_pwd);

    Admin findAdminByPhone(String admin_phone);

    Boolean addAdmin(Admin admin);
}
