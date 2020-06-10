package com.example.demo.mapper;

import com.example.demo.entity.Admin;
import org.springframework.stereotype.Repository;

/**
 * @author mhh
 * @date 2020/6/10
 */
@Repository
public interface AdminMapper {
    public Admin findAdminById(String admin_id);
    public Admin doLoginAdmin(String admin_phone,String admin_pwd);
    public Admin findAdminByPhone(String admin_phone);
    public Boolean addAdmin(Admin admin);
}
