package com.example.demo.entity;

public class Data {
    private String ddata_id;
    private String ddata_time;
    private String process_id;
    private float pm1_0;
    private float um0_3;
    private float um2_5;
    private float pm2_5;
    private float um0_5;
    private float um5_0;
    private float pm10;
    private float um1_0;
    private float um10;
    private float hcho;
    private float tvoc;
    private float co2;
    private float temp;
    private float rh;

    public String getDdata_id() {
        return ddata_id;
    }

    public void setDdata_id(String ddata_id) {
        this.ddata_id = ddata_id;
    }

    public String getDdata_time() {
        return ddata_time;
    }

    public void setDdata_time(String ddata_time) {
        this.ddata_time = ddata_time;
    }

    public String getProcess_id() {
        return process_id;
    }

    public void setProcess_id(String process_id) {
        this.process_id = process_id;
    }
}
