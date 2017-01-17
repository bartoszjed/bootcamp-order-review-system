package com.tesco.bootcamp.orderreview.service;

import com.tesco.bootcamp.orderreview.adaptor.CustomerApiAdaptor;
import com.tesco.bootcamp.orderreview.adaptor.OrderApiAdaptor;
import com.tesco.bootcamp.orderreview.adaptor.OrderStatusApiAdaptor;
import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import com.tesco.bootcamp.orderreview.representations.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderReviewService {

    private final CustomerApiAdaptor customerAdapter;
    private final OrderApiAdaptor orderApiAdaptor;
    private final OrderStatusApiAdaptor orderStatusApiAdaptor;

    @Autowired
    public OrderReviewService(CustomerApiAdaptor customerAdapter,
                              OrderApiAdaptor orderApiAdaptor,
                              OrderStatusApiAdaptor orderStatusApiAdaptor) {
        this.customerAdapter = customerAdapter;
        this.orderApiAdaptor = orderApiAdaptor;
        this.orderStatusApiAdaptor = orderStatusApiAdaptor;
    }

    public Customer getCustomerName(String loginID) {
       return customerAdapter.call(loginID);
    }

    public List<CustomerOrder> getOrderList(int customerID) {
        return orderApiAdaptor.call(customerID);
    }

    public OrderStatus getOrderStatus(String orderId){ return orderStatusApiAdaptor.call(orderId);}

}
