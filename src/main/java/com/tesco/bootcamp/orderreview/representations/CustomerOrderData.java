package com.tesco.bootcamp.orderreview.representations;

import java.util.List;

public class CustomerOrderData {

    private final String id;
    private final List<Product> products;
    private final String orderDateTime;
    private final String orderStatus;

    public CustomerOrderData(String id, List<Product> products, String orderDateTime, @SuppressWarnings("SameParameterValue") String orderStatus) {
        this.id = id;
        this.products = products;
        this.orderDateTime = orderDateTime;
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
