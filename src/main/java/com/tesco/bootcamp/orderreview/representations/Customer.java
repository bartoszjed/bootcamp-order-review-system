package com.tesco.bootcamp.orderreview.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

    private final int id;
    private final CustomerName customerName;

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
