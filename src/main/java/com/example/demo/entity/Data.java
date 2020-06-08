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

    public float getPm1_0() {
        return pm1_0;
    }

    public void setPm1_0(float pm1_0) {
        this.pm1_0 = pm1_0;
    }

    public float getUm0_3() {
        return um0_3;
    }

    public void setUm0_3(float um0_3) {
        this.um0_3 = um0_3;
    }

    public float getUm2_5() {
        return um2_5;
    }

    public void setUm2_5(float um2_5) {
        this.um2_5 = um2_5;
    }

    public float getPm2_5() {
        return pm2_5;
    }

    public void setPm2_5(float pm2_5) {
        this.pm2_5 = pm2_5;
    }

    public float getUm0_5() {
        return um0_5;
    }

    public void setUm0_5(float um0_5) {
        this.um0_5 = um0_5;
    }

    public float getUm5_0() {
        return um5_0;
    }

    public void setUm5_0(float um5_0) {
        this.um5_0 = um5_0;
    }

    public float getPm10() {
        return pm10;
    }

    public void setPm10(float pm10) {
        this.pm10 = pm10;
    }

    public float getUm1_0() {
        return um1_0;
    }

    public void setUm1_0(float um1_0) {
        this.um1_0 = um1_0;
    }

    public float getUm10() {
        return um10;
    }

    public void setUm10(float um10) {
        this.um10 = um10;
    }

    public float getHcho() {
        return hcho;
    }

    public void setHcho(float hcho) {
        this.hcho = hcho;
    }

    public float getTvoc() {
        return tvoc;
    }

    public void setTvoc(float tvoc) {
        this.tvoc = tvoc;
    }

    public float getCo2() {
        return co2;
    }

    public void setCo2(float co2) {
        this.co2 = co2;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getRh() {
        return rh;
    }

    public void setRh(float rh) {
        this.rh = rh;
    }

    @Override
    public String toString() {
        return "Data{" +
                "ddata_id='" + ddata_id + '\'' +
                ", ddata_time='" + ddata_time + '\'' +
                ", process_id='" + process_id + '\'' +
                ", pm1_0=" + pm1_0 +
                ", um0_3=" + um0_3 +
                ", um2_5=" + um2_5 +
                ", pm2_5=" + pm2_5 +
                ", um0_5=" + um0_5 +
                ", um5_0=" + um5_0 +
                ", pm10=" + pm10 +
                ", um1_0=" + um1_0 +
                ", um10=" + um10 +
                ", hcho=" + hcho +
                ", tvoc=" + tvoc +
                ", co2=" + co2 +
                ", temp=" + temp +
                ", rh=" + rh +
                '}';
    }
}
