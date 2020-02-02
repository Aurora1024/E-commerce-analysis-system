package com.example.cc.dto;

public class TimeAndPrice {

    private int time;

    private double price;

    public TimeAndPrice(int time, double price) {
        this.time = time;
        this.price = price;
    }

    public TimeAndPrice() {
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
