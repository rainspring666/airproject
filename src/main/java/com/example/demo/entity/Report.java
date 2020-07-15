package com.example.demo.entity;

public class Report {
    private String report_id;
    private String describes;
    private String picurl;
    private String operate_plan;
    private String create_time;
    private String validation;
    private String site_condition;

    public Report() {
        describes = "";
        picurl = "";
        operate_plan = "";
        create_time = "";
        validation = "";
        site_condition = "";
    }

    public String getReport_id() {
        return report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getOperate_plan() {
        return operate_plan;
    }

    public void setOperate_plan(String operate_plan) {
        this.operate_plan = operate_plan;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getSite_condition() {
        return site_condition;
    }

    public void setSite_condition(String site_condition) {
        this.site_condition = site_condition;
    }

    @Override
    public String toString() {
        return "Report{" +
                "report_id='" + report_id + '\'' +
                ", describes='" + describes + '\'' +
                ", picurl='" + picurl + '\'' +
                ", operate_plan='" + operate_plan + '\'' +
                ", create_time='" + create_time + '\'' +
                ", validation='" + validation + '\'' +
                ", site_condition='" + site_condition + '\'' +
                '}';
    }
}
