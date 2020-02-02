package com.example.cc.entity;

public class PMonth {

    private String product_id;

    private int month;

    private int m_sales;

    public PMonth(String product_id, int month, int m_sales) {
        this.product_id = product_id;
        this.month = month;
        this.m_sales = m_sales;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getM_sales() {
        return m_sales;
    }

    public void setM_sales(int m_sales) {
        this.m_sales = m_sales;
    }
}
