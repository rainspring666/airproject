package com.example.demo.entity;

public class Order {
    private String order_id;

    private String user_id;

    private String op_id;

    private String order_state;

    private String order_createtime;

    private String order_time;

    private String order_class;

    private String order_modelf;

    private Float order_scope;

    private String order_descripe;

    private String order_address;

    private String order_contact;

    private String order_phone;

    private String order_others;

    private Float order_cost;

    private String order_pollution;

    private Integer order_moremoney;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOp_id() {
        return op_id;
    }

    public void setOp_id(String op_id) {
        this.op_id = op_id;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getOrder_createtime() {
        return order_createtime;
    }

    public void setOrder_createtime(String order_createtime) {
        this.order_createtime = order_createtime;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getOrder_class() {
        return order_class;
    }

    public void setOrder_class(String order_class) {
        this.order_class = order_class;
    }

    public String getOrder_modelf() {
        return order_modelf;
    }

    public void setOrder_modelf(String order_modelf) {
        this.order_modelf = order_modelf;
    }

    public Float getOrder_scope() {
        return order_scope;
    }

    public void setOrder_scope(Float order_scope) {
        this.order_scope = order_scope;
    }

    public String getOrder_descripe() {
        return order_descripe;
    }

    public void setOrder_descripe(String order_descripe) {
        this.order_descripe = order_descripe;
    }

    public String getOrder_address() {
        return order_address;
    }

    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }

    public String getOrder_contact() {
        return order_contact;
    }

    public void setOrder_contact(String order_contact) {
        this.order_contact = order_contact;
    }

    public String getOrder_phone() {
        return order_phone;
    }

    public void setOrder_phone(String order_phone) {
        this.order_phone = order_phone;
    }

    public String getOrder_others() {
        return order_others;
    }

    public void setOrder_others(String order_others) {
        this.order_others = order_others;
    }

    public Float getOrder_cost() {
        return order_cost;
    }

    public void setOrder_cost(Float order_cost) {
        this.order_cost = order_cost;
    }

    public String getOrder_pollution() {
        return order_pollution;
    }

    public void setOrder_pollution(String order_pollution) {
        this.order_pollution = order_pollution;
    }

    public Integer getOrder_moremoney() {
        return order_moremoney;
    }

    public void setOrder_moremoney(Integer order_moremoney) {
        this.order_moremoney = order_moremoney;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", op_id='" + op_id + '\'' +
                ", order_state=" + order_state +
                ", order_createtime='" + order_createtime + '\'' +
                ", order_time='" + order_time + '\'' +
                ", order_class='" + order_class + '\'' +
                ", order_modelf='" + order_modelf + '\'' +
                ", order_scope=" + order_scope +
                ", order_descripe='" + order_descripe + '\'' +
                ", order_address='" + order_address + '\'' +
                ", order_contact='" + order_contact + '\'' +
                ", order_phone='" + order_phone + '\'' +
                ", order_others='" + order_others + '\'' +
                ", order_cost=" + order_cost +
                ", order_pollution='" + order_pollution + '\'' +
                ", order_moremoney=" + order_moremoney +
                '}';
    }
}