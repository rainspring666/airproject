package com.example.demo.entity;

public class Material {
    private String material_id;
    private String ma_name;
    private int ma_number;
    private String ma_other;

    public String getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(String material_id) {
        this.material_id = material_id;
    }

    public String getMa_name() {
        return ma_name;
    }

    public void setMa_name(String ma_name) {
        this.ma_name = ma_name;
    }

    public int getMa_number() {
        return ma_number;
    }

    public void setMa_number(int ma_number) {
        this.ma_number = ma_number;
    }

    public String getMa_other() {
        return ma_other;
    }

    public void setMa_other(String ma_other) {
        this.ma_other = ma_other;
    }
}
