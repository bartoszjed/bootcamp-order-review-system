package com.tesco.bootcamp.orderreview.representations;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by manindrajha on 11/01/2017.
 */
public class CustomerOrder {

    private String id;
    private Customer customer;
    private List<Product> productList;
    private OrderDestination orderDestination;
    private String orderDateAndTime;

    @JsonCreator
    public CustomerOrder(@JsonProperty("id") String id,
                         @JsonProperty("customer") Customer customer,
                         @JsonProperty("products") List<Product> productList,
                         @JsonProperty("orderDestination") OrderDestination orderDestination,
                         @JsonProperty("orderDateTime") String orderDateAndTime) {
        this.id = id;
        this.customer = customer;
        this.productList = productList;
        this.orderDestination = orderDestination;
        this.orderDateAndTime = orderDateAndTime;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public OrderDestination getOrderDestination() {
        return orderDestination;
    }

    public String getOrderDateAndTime() {
        return orderDateAndTime;
    }
}
