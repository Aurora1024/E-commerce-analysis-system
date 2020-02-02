package com.example.cc.entity;

public class CMonth {

    private String category_id;

    private int month;

    private int m_sales;

    public CMonth(String category_id, int month, int m_sales) {
        this.category_id = category_id;
        this.month = month;
        this.m_sales = m_sales;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
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
