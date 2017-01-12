package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by manindrajha on 11/01/2017.
 */

@Component
public interface OrderSystemAdaptor {

    public List<CustomerOrder> call(String customerId);

}
