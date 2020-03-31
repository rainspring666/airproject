package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
    private String orderId;

    private String userId;

    private String opId;

    private Integer orderState;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderCreattime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;

    private String evaluationId;

    private Integer orderClass;

    private String orderModelf;

    private Float orderScope;

    private String orderDescripe;

    private String orderAddress;

    private String orderContact;

    private String orderPhone;

    private String orderOthers;

    private Float orderCost;

    private Integer orderPollution;

    private Boolean orderMoremoney;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId == null ? null : opId.trim();
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Date getOrderCreattime() {
        return orderCreattime;
    }

    public void setOrderCreattime(Date orderCreattime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getEvaluationId() {
        return evaluationId;
    }

    public void setEvaluationId(String evaluationId) {
        this.evaluationId = evaluationId == null ? null : evaluationId.trim();
    }

    public Integer getOrderClass() {
        return orderClass;
    }

    public void setOrderClass(Integer orderClass) {
        this.orderClass = orderClass;
    }

    public String getOrderModelf() {
        return orderModelf;
    }

    public void setOrderModelf(String orderModelf) {
        this.orderModelf = orderModelf == null ? null : orderModelf.trim();
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
        this.orderDescripe = orderDescripe == null ? null : orderDescripe.trim();
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress == null ? null : orderAddress.trim();
    }

    public String getOrderContact() {
        return orderContact;
    }

    public void setOrderContact(String orderContact) {
        this.orderContact = orderContact == null ? null : orderContact.trim();
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone == null ? null : orderPhone.trim();
    }

    public String getOrderOthers() {
        return orderOthers;
    }

    public void setOrderOthers(String orderOthers) {
        this.orderOthers = orderOthers == null ? null : orderOthers.trim();
    }

    public Float getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(Float orderCost) {
        this.orderCost = orderCost;
    }

    public Integer getOrderPollution() {
        return orderPollution;
    }

    public void setOrderPollution(Integer orderPollution) {
        this.orderPollution = orderPollution;
    }

    public Boolean getOrderMoremoney() {
        return orderMoremoney;
    }

    public void setOrderMoremoney(Boolean orderMoremoney) {
        this.orderMoremoney = orderMoremoney;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", opId='" + opId + '\'' +
                ", orderState=" + orderState +
                ", orderCreattime=" + orderCreattime +
                ", orderTime=" + orderTime +
                ", evaluationId='" + evaluationId + '\'' +
                ", orderClass=" + orderClass +
                ", orderModelf='" + orderModelf + '\'' +
                ", orderScope=" + orderScope +
                ", orderDescripe='" + orderDescripe + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", orderContact='" + orderContact + '\'' +
                ", orderPhone='" + orderPhone + '\'' +
                ", orderOthers='" + orderOthers + '\'' +
                ", orderCost=" + orderCost +
                ", orderPollution=" + orderPollution +
                ", orderMoremoney=" + orderMoremoney +
                '}';
    }
}