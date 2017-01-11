package com.tesco.bootcamp.orderreview.controller;

import com.tesco.bootcamp.orderreview.representations.*;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class OrderReviewController {

  @Autowired
  OrderReviewService orderReviewService;

  public OrderReviewController() {
    super();
  }

  public OrderReviewController(OrderReviewService orderReviewService) {
    this.orderReviewService = orderReviewService;
  }

  @RequestMapping("/order-review")
  public void getOrdersToReview(Model model,
      @RequestParam(value = "customerID", required = true) String customerID) {

    model.addAttribute("customerName", orderReviewService.getCustomerName(customerID));

    // Temporary test data for order display.
    ArrayList<Product> products = new ArrayList<Product>();
    products.add(new Product("Baked Beans","Tinned"));
    products.add(new Product("Petite Pois","Tinned"));
    products.add(new Product("Tomato Soup","Tinned"));

    Customer customer = new Customer(1,new CustomerName("Fred", "Bloggs"));

    OrderDestination orderDestination = new OrderDestination(1,1);

    CustomerOrder customerOrder1 = new CustomerOrder("1",customer, products,orderDestination,"2017-01-01");
    customerOrder1.setOrderStatus("Picked");
    CustomerOrder customerOrder2 = new CustomerOrder("2",customer, products,orderDestination,"2017-01-02");
    customerOrder2.setOrderStatus("Ready to Pick");
    CustomerOrder customerOrder3 = new CustomerOrder("3",customer, products,orderDestination,"2017-01-03");
    CustomerOrder customerOrder4 = new CustomerOrder("4",customer, products,orderDestination,"2017-01-04");

    ArrayList<CustomerOrder> customerOrders = new ArrayList<CustomerOrder>();
    customerOrders.add(customerOrder1);
    customerOrders.add(customerOrder2);
    customerOrders.add(customerOrder3);
    customerOrders.add(customerOrder3);

    model.addAttribute("customerOrders", customerOrders);

    // Maybe set the customer details from the first order details !
    if (! customerOrders.isEmpty()) {
      model.addAttribute("customerId", customerOrders.get(0).getCustomer().getId());
      model.addAttribute("alternativeCustomerName",
              customerOrders.get(0).getCustomer().getCustomerName().getSurname() + ", " +
                      customerOrders.get(0).getCustomer().getCustomerName().getFirstName());
    }













  }
}
