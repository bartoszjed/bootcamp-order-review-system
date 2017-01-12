package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DummyOrderSystemAdaptor implements OrderSystemAdaptor {

    public DummyOrderSystemAdaptor() {
    }

    @Override
    public List<CustomerOrder> call(int customerId) {

        // Temporary test data for order display.
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product("Baked Beans", "Tinned"));
        products.add(new Product("Petite Pois", "Tinned"));
        products.add(new Product("Tomato Soup", "Tinned"));
        products.add(new Product("Spaghetti Hoops", "Tinned"));
        products.add(new Product("Tuna Chunks", "Tinned"));

        Customer customer = new Customer(1, new CustomerName("Fred", "Bloggs"));

        OrderDestination orderDestination = new OrderDestination(1, 1);

        CustomerOrder customerOrder1 = new CustomerOrder("1", customer, products, orderDestination, "2017-01-01");
        CustomerOrder customerOrder2 = new CustomerOrder("2", customer, products, orderDestination, "2017-01-02");
        CustomerOrder customerOrder3 = new CustomerOrder("3", customer, products, orderDestination, "2017-01-03");
        CustomerOrder customerOrder4 = new CustomerOrder("4", customer, products, orderDestination, "2017-01-04");

        ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
        customerOrders.add(customerOrder1);
        customerOrders.add(customerOrder2);
        customerOrders.add(customerOrder3);
        customerOrders.add(customerOrder4);

        return customerOrders;
    }
}
