package com.tesco.bootcamp.orderreview.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderStatus {

    private final String orderId;
    private final String status;

    @JsonCreator
    public OrderStatus(@JsonProperty("orderId") String orderId, @JsonProperty("status") String status) {
        this.orderId = orderId;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStatus() {
        return status;
    }
}
