package com.example.cc.entity;

public class Product {

    private String product_id;

    private String product;

    private double price;

    private int inventory;

    private String category;

    private int product_sales;

    public Product(){}

    public Product(String product_id, String product, double price, int inventory, String category, int product_sales) {
        this.product_id = product_id;
        this.product = product;
        this.price = price;
        this.inventory = inventory;
        this.category = category;
        this.product_sales = product_sales;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getProduct_sales() {
        return product_sales;
    }

    public void setProduct_sales(int product_sales) {
        this.product_sales = product_sales;
    }
}
