package com.tesco.bootcamp.orderreview.service;

import com.tesco.bootcamp.orderreview.adapters.CustomerServiceAdaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderReviewService {

    private final CustomerServiceAdaptor customerAdapter;

    @Autowired
    public OrderReviewService(CustomerServiceAdaptor customerAdapter){
        this.customerAdapter = customerAdapter;
    }

    public String getCustomerName(String loginID) {
       return customerAdapter.call(loginID);
    }
}
