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
    private List<Product> products;
    private OrderDestination orderDestination;
    private String orderDateTime;

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
