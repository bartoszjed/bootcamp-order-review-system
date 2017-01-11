package com.tesco.bootcamp.orderreview.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maheshnakum on 11/01/2017.
 */
public class Customer {

    private int id;
    private CustomerName customerName;

    @JsonCreator
    public Customer(@JsonProperty("id") int id, @JsonProperty("name") CustomerName customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public CustomerName getCustomerName() {
        return customerName;
    }
}
