package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.CustomerOrder;

import java.util.List;

/**
 * Created by manindrajha on 11/01/2017.
 */
public interface OrderSystemAdaptor {

    public List<CustomerOrder> call(String customerId);

}
