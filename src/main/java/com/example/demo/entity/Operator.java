package com.example.demo.entity;

public class Operator {
    private String op_id;
    private String op_name;
    private String op_pwd;
    private String op_phone;
    private String OP_photo;//丢弃
    private String op_score;//丢弃
    private int op_state;
    private String wx_openid;//新增字段 用来绑定微信的ID

    public String getWx_openid(){
        return wx_openid;
    }
    public void setWx_openid(String id){
        this.wx_openid = id;
    }

    public String getOp_id() {
        return op_id;
    }

    public void setOp_id(String op_id) {
        this.op_id = op_id;
    }

    public String getOp_name() {
        return op_name;
    }

    public void setOp_name(String op_name) {
        this.op_name = op_name;
    }

    public String getOp_pwd() {
        return op_pwd;
    }

    public void setOp_pwd(String op_pwd) {
        this.op_pwd = op_pwd;
    }

    public String getOp_phone() {
        return op_phone;
    }

    public void setOp_phone(String op_phone) {
        this.op_phone = op_phone;
    }

    public String getOP_photo() {
        return OP_photo;
    }

    public void setOP_photo(String OP_photo) {
        this.OP_photo = OP_photo;
    }

    public String getOp_score() {
        return op_score;
    }

    public void setOp_score(String op_score) {
        this.op_score = op_score;
    }

    public int getOp_state() {
        return op_state;
    }

    public void setOp_state(int op_state) {
        this.op_state = op_state;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "op_id='" + op_id + '\'' +
                ", op_name='" + op_name + '\'' +
                ", op_pwd='" + op_pwd + '\'' +
                ", op_phone='" + op_phone + '\'' +
                ", OP_photo='" + OP_photo + '\'' +
                ", op_score='" + op_score + '\'' +
                ", op_state=" + op_state +
                ", wx_openid='" + wx_openid + '\'' +
                '}';
    }
}
