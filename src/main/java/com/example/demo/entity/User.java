package com.example.demo.entity;


public class User {
    private String user_id;
    private String user_pwd;
    private String user_phone;
    private String user_name;
    private String user_nickname;
    private String user_picture;
    private int user_gender;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
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

    public String getUser_picture() {
        return user_picture;
    }

    public void setUser_picture(String user_picture) {
        this.user_picture = user_picture;
    }

    public int getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(int user_gender) {
        this.user_gender = user_gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user_id +
                ", userName='" + user_pwd + '\'' +
                ", passWord='" + user_phone + '\'' +
                ", realName='" + user_name + '\'' +
                ", realName='" + user_nickname + '\'' +
                ", realName='" + user_picture + '\'' +
                '}';
    }

}
