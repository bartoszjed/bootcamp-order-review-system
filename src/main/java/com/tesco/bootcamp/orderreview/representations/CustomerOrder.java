package com.tesco.bootcamp.orderreview.representations;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomerOrder {

    private final String id;
    private final Customer customer;
    private final List<Product> products;
    private final OrderDestination orderDestination;
    private final String orderDateTime;

    @JsonCreator
    public CustomerOrder(@JsonProperty("id") String id,
                         @JsonProperty("customer") Customer customer,
                         @JsonProperty("productList") List<Product> products,
                         @JsonProperty("orderDestination") OrderDestination orderDestination,
                         @JsonProperty("orderDateTime") String orderDateTime) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.orderDestination = orderDestination;
        this.orderDateTime = orderDateTime;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public OrderDestination getOrderDestination() {
        return orderDestination;
    }

    public String getOrderDateTime() {
        return orderDateTime;
    }

}
