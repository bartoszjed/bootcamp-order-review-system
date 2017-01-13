package com.tesco.bootcamp.orderreview.representations;

import java.util.List;

/**
 * Created by xm39 on 13/01/2017.
 */
public class CustomerOrderData {

    private String id;
    private List<Product> products;
    private String orderDateTime;
    private String orderStatus;

    public CustomerOrderData(String id, List<Product> products, String orderDateTime, String orderStatus) {
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
