package com.example.cc.entity;

import java.util.Date;

public class PDaily {

    private String product_id;

    private int day;

    private int d_sales;

    private double d_price;

    public PDaily(String product_id, int day, int d_sales, double d_price) {
        this.product_id = product_id;
        this.day = day;
        this.d_sales = d_sales;
        this.d_price = d_price;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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

    public double getD_price() {
        return d_price;
    }

    public void setD_price(double d_price) {
        this.d_price = d_price;
    }
}
