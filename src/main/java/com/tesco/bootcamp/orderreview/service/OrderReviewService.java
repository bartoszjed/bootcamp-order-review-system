package com.tesco.bootcamp.orderreview.service;

import com.tesco.bootcamp.orderreview.adapters.CustomerServiceAdaptor;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<CustomerOrder> getOrderList(String customerID){
        List<CustomerOrder> listCustomer = new ArrayList<>();

        return listCustomer;

    }
}
