package com.example.cc.entity;

public class CDaily {

    private String category_id;

    private int day;

    private int d_sales;

    public CDaily(String category_id, int day, int d_sales) {
        this.category_id = category_id;
        this.day = day;
        this.d_sales = d_sales;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getD_sales() {
        return d_sales;
    }

    public void setD_sales(int d_sales) {
        this.d_sales = d_sales;
    }
}
