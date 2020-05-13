package com.example.demo.entity;

import java.io.File;

public class Order {
    private String orderId;

    private String userId;

    private String opId;

    private Integer orderState;

    private String orderCreatetime;

    private String orderTime;

    private String orderClass;

    private String orderModelf;

    private Float orderScope;

    private String orderDescripe;

    private String orderAddress;

    private String orderContact;

    private String orderPhone;

    private String orderOthers;

    private Float orderCost;

    private String orderPollution;

    private Integer orderMoremoney;

    // public Order(String orderId, String userId, String opId, Integer orderState, String orderCreatetime, String orderTime, String orderClass, String orderModelf, Float orderScope, String orderDescripe, String orderAddress, String orderContact, String orderPhone, String orderOthers, Float orderCost, String orderPollution, Integer orderMoremoney) {
    //     this.orderId = orderId;
    //     this.userId = userId;
    //     this.opId = opId;
    //     this.orderState = orderState;
    //     this.orderCreatetime = orderCreatetime;
    //     this.orderTime = orderTime;
    //     this.orderClass = orderClass;
    //     this.orderModelf = orderModelf;
    //     this.orderScope = orderScope;
    //     this.orderDescripe = orderDescripe;
    //     this.orderAddress = orderAddress;
    //     this.orderContact = orderContact;
    //     this.orderPhone = orderPhone;
    //     this.orderOthers = orderOthers;
    //     this.orderCost = orderCost;
    //     this.orderPollution = orderPollution;
    //     this.orderMoremoney = orderMoremoney;
    // }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public String getOrderCreatetime() {
        return orderCreatetime;
    }

    public void setOrderCreatetime(String orderCreatetime) {
        this.orderCreatetime = orderCreatetime;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderClass() {
        return orderClass;
    }

    public void setOrderClass(String orderClass) {
        this.orderClass = orderClass;
    }

    public String getOrderModelf() {
        return orderModelf;
    }

    public void setOrderModelf(String orderModelf) {
        this.orderModelf = orderModelf;
    }

    public Float getOrderScope() {
        return orderScope;
    }

    public void setOrderScope(Float orderScope) {
        this.orderScope = orderScope;
    }

    public String getOrderDescripe() {
        return orderDescripe;
    }

    public void setOrderDescripe(String orderDescripe) {
        this.orderDescripe = orderDescripe;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderContact() {
        return orderContact;
    }

    public void setOrderContact(String orderContact) {
        this.orderContact = orderContact;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getOrderOthers() {
        return orderOthers;
    }

    public void setOrderOthers(String orderOthers) {
        this.orderOthers = orderOthers;
    }

    public Float getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Float orderCost) {
        this.orderCost = orderCost;
    }

    public String getOrderPollution() {
        return orderPollution;
    }

    public void setOrderPollution(String orderPollution) {
        this.orderPollution = orderPollution;
    }

    public Integer getOrderMoremoney() {
        return orderMoremoney;
    }

    public void setOrderMoremoney(Integer orderMoremoney) {
        this.orderMoremoney = orderMoremoney;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", opId='" + opId + '\'' +
                ", orderState=" + orderState +
                ", orderCreatetime='" + orderCreatetime + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", orderClass='" + orderClass + '\'' +
                ", orderModelf='" + orderModelf + '\'' +
                ", orderScope=" + orderScope +
                ", orderDescripe='" + orderDescripe + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderContact='" + orderContact + '\'' +
                ", orderPhone='" + orderPhone + '\'' +
                ", orderOthers='" + orderOthers + '\'' +
                ", orderCost=" + orderCost +
                ", orderPollution='" + orderPollution + '\'' +
                ", orderMoremoney=" + orderMoremoney +
                '}';
    }
}