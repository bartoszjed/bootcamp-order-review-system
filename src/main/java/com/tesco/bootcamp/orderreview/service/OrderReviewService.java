package com.tesco.bootcamp.orderreview.service;

import com.tesco.bootcamp.orderreview.adaptor.CustomerServiceAdaptor;
import com.tesco.bootcamp.orderreview.adaptor.OrderSystemAdaptor;
import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderReviewService {

    private final CustomerServiceAdaptor customerAdapter;
    private final OrderSystemAdaptor orderSystemAdaptor;

    @Autowired
    public OrderReviewService(CustomerServiceAdaptor customerAdapter, OrderSystemAdaptor orderSystemAdaptor) {
        this.customerAdapter = customerAdapter;
        this.orderSystemAdaptor = orderSystemAdaptor;
    }

    public Customer getCustomerName(String loginID) {
       return customerAdapter.call(loginID);
    }

    public List<CustomerOrder> getOrderList(int customerID) {
        return orderSystemAdaptor.call(customerID);
    }
}
