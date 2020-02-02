package com.example.cc.dto;

public class TimeAndSales {

    private int time;

    private int sales;

    public TimeAndSales(){}

    public TimeAndSales(int time, int sales) {
        this.time = time;
        this.sales = sales;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
