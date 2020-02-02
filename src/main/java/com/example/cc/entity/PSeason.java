package com.example.cc.entity;

public class PSeason {

    private String product_id;

    private int season;

    private int s_sales;

    public PSeason(String product_id, int season, int s_sales) {
        this.product_id = product_id;
        this.season = season;
        this.s_sales = s_sales;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getS_sales() {
        return s_sales;
    }

    public void setS_sales(int s_sales) {
        this.s_sales = s_sales;
    }
}
