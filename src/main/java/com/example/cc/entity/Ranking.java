package com.example.cc.entity;

public class Ranking {

    private String category_id;

    private String category;

    private String product_id;

    private String product;

    private int category_sales;

    public Ranking(String category_id, String category, String product_id, String product, int category_sales) {
        this.category_id = category_id;
        this.category = category;
        this.product_id = product_id;
        this.product = product;
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

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getCategory_sales() {
        return category_sales;
    }

    public void setCategory_sales(int category_sales) {
        this.category_sales = category_sales;
    }
}
