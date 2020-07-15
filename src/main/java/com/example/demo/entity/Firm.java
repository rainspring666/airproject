package com.example.demo.entity;

public class Firm {
    private String firm_id;
    private String firm_name;
    private String firm_ceo;

    public String getFirm_id() {
        return firm_id;
    }

    public void setFirm_id(String firm_id) {
        this.firm_id = firm_id;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public String getFirm_ceo() {
        return firm_ceo;
    }

    public void setFirm_ceo(String firm_ceo) {
        this.firm_ceo = firm_ceo;
    }

    @Override
    public String toString() {
        return "Firm{" +
                "firm_id='" + firm_id + '\'' +
                ", firm_name='" + firm_name + '\'' +
                ", firm_ceo='" + firm_ceo + '\'' +
                '}';
    }
}
