package com.example.demo.entity;

public class User_info {
    private String user_id;
    private String user_name;
    private String user_nickname;
    private int user_gender;
    private String user_address;
    private String firm_id;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public int getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(int user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getFirm_id() {
        return firm_id;
    }

    public void setFirm_id(String firm_id) {
        this.firm_id = firm_id;
    }

    @Override
    public String toString() {
        return "User_info{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_gender=" + user_gender +
                ", user_address='" + user_address + '\'' +
                ", firm_id='" + firm_id + '\'' +
                '}';
    }
}
