package com.example.demo.entity;

public class Admin {
    private String admin_id;
    private String admin_name;
    private String admin_pwd;
    private String admin_phone;
    private Integer admin_role;

    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(String admin_pwd) {
        this.admin_pwd = admin_pwd;
    }

    public String getAdmin_phone() {
        return admin_phone;
    }

    public void setAdmin_phone(String admin_phone) {
        this.admin_phone = admin_phone;
    }

    public Integer getAdmin_role() {
        return admin_role;
    }

    public void setAdmin_role(Integer admin_role) {
        this.admin_role = admin_role;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id='" + admin_id + '\'' +
                ", admin_name='" + admin_name + '\'' +
                ", admin_pwd='" + admin_pwd + '\'' +
                ", admin_phone='" + admin_phone + '\'' +
                ", admin_role=" + admin_role +
                '}';
    }
}
