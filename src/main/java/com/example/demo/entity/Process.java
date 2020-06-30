package com.example.demo.entity;

public class Process {
    private String process_id;
    private String user_id;
    private String order_id;
    private String pro_generator;
    private String pro_sampler;
    private String pro_report;
    private String pro_result;
    private String pro_eq;
    private String pro_material;
    private String pro_starttime;
    private String pro_state;
    private String pro_endtime;
    private String pro_pictures;
    private String ddata_id;
    private String express_id;
    private String express_name;
    private int pro_counttime;

    public String getProcess_id() {
        return process_id;
    }

    public void setProcess_id(String process_id) {
        this.process_id = process_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getPro_generator() {
        return pro_generator;
    }

    public void setPro_generator(String pro_generator) {
        this.pro_generator = pro_generator;
    }

    public String getPro_sampler() {
        return pro_sampler;
    }

    public void setPro_sampler(String pro_sampler) {
        this.pro_sampler = pro_sampler;
    }

    public String getPro_report() {
        return pro_report;
    }

    public void setPro_report(String pro_report) {
        this.pro_report = pro_report;
    }

    public String getPro_result() {
        return pro_result;
    }

    public void setPro_result(String pro_result) {
        this.pro_result = pro_result;
    }

    public String getPro_eq() {
        return pro_eq;
    }

    public void setPro_eq(String pro_eq) {
        this.pro_eq = pro_eq;
    }

    public String getPro_material() {
        return pro_material;
    }

    public void setPro_material(String pro_material) {
        this.pro_material = pro_material;
    }

    public String getPro_starttime() {
        return pro_starttime;
    }

    public void setPro_starttime(String pro_starttime) {
        this.pro_starttime = pro_starttime;
    }

    public String getPro_state() {
        return pro_state;
    }

    public void setPro_state(String pro_state) {
        this.pro_state = pro_state;
    }

    public String getPro_endtime() {
        return pro_endtime;
    }

    public void setPro_endtime(String pro_endtime) {
        this.pro_endtime = pro_endtime;
    }

    public String getPro_pictures() {
        return pro_pictures;
    }

    public void setPro_pictures(String pro_pictures) {
        this.pro_pictures = pro_pictures;
    }

    public String getDdata_id() {
        return ddata_id;
    }

    public void setDdata_id(String ddata_id) {
        this.ddata_id = ddata_id;
    }

    public String getExpress_id() {
        return express_id;
    }

    public void setExpress_id(String express_id) {
        this.express_id = express_id;
    }

    public String getExpress_name() {
        return express_name;
    }

    public void setExpress_name(String express_name) {
        this.express_name = express_name;
    }

    public int getPro_counttime() {
        return pro_counttime;
    }

    public void setPro_counttime(int pro_counttime) {
        this.pro_counttime = pro_counttime;
    }

    @Override
    public String toString() {
        return "Process{" +
                "process_id='" + process_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", order_id='" + order_id + '\'' +
                ", pro_generator='" + pro_generator + '\'' +
                ", pro_sampler='" + pro_sampler + '\'' +
                ", pro_report='" + pro_report + '\'' +
                ", pro_result='" + pro_result + '\'' +
                ", pro_eq='" + pro_eq + '\'' +
                ", pro_material='" + pro_material + '\'' +
                ", pro_starttime='" + pro_starttime + '\'' +
                ", pro_state='" + pro_state + '\'' +
                ", pro_endtime='" + pro_endtime + '\'' +
                ", pro_pictures='" + pro_pictures + '\'' +
                ", ddata_id='" + ddata_id + '\'' +
                ", express_id='" + express_id + '\'' +
                ", express_name='" + express_name + '\'' +
                ", pro_counttime=" + pro_counttime +
                '}';
    }
}
