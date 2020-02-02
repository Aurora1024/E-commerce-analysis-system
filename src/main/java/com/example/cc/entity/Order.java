package com.example.cc.entity;

import java.util.Date;

public class Order {

    private String order_id;

    private String order_time;

    private double order_price;

    private String buyer;

    private String address;

    private String phone;

    private String product_id;

    public Order(String order_id, String order_time, double order_price, String buyer, String address, String phone, String product_id) {
        this.order_id = order_id;
        this.order_time = order_time;
        this.order_price = order_price;
        this.buyer = buyer;
        this.address = address;
        this.phone = phone;
        this.product_id = product_id;
    }

    public Order(){}

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(double order_price) {
        this.order_price = order_price;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}
