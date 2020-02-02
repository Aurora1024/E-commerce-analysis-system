package com.example.cc.entity;

public class Category {

    private String category_id;

    private String category;

    private int category_sales;

    public Category(String category_id, String category, int category_sales) {
        this.category_id = category_id;
        this.category = category;
        this.category_sales = category_sales;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategory_sales() {
        return category_sales;
    }

    public void setCategory_sales(int category_sales) {
        this.category_sales = category_sales;
    }
}
