package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mhh
 * @date 2020/6/10
 */
@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Admin findAdminById(String admin_id){
        return adminMapper.findAdminById(admin_id);
    }
    public Admin doLoginAdmin(String admin_phone,String admin_pwd){
        return adminMapper.doLoginAdmin(admin_phone,admin_pwd);
    }
    public Admin findAdminByPhone(String admin_phone){
        return adminMapper.findAdminByPhone(admin_phone);
    }
    public Boolean addAdmin(Admin admin){
        return adminMapper.addAdmin(admin);
    }

}
