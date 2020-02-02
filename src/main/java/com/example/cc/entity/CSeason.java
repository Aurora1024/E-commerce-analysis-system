package com.example.cc.entity;

public class CSeason {

    private String category_id;

    private int season;

    private int s_sales;

    public CSeason(String category_id, int season, int s_sales) {
        this.category_id = category_id;
        this.season = season;
        this.s_sales = s_sales;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
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
