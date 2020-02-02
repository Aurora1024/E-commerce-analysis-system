package com.example.cc.dto;

public class CategoryAndSales {

    private String category;

    private int sales;

    public CategoryAndSales(String category, int sales) {
        this.category = category;
        this.sales = sales;
    }

    public CategoryAndSales() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
