package com.example.cc.dto;

public class PidProPsales {

    private String product_id;

    private String product;

    private int category_sales;

    public PidProPsales(String product_id, String product, int category_sales) {
        this.product_id = product_id;
        this.product = product;
        this.category_sales = category_sales;
    }

    public PidProPsales() {
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
