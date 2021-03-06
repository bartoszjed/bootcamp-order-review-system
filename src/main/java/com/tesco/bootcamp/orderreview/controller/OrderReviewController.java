package com.tesco.bootcamp.orderreview.controller;

import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import com.tesco.bootcamp.orderreview.representations.CustomerOrderData;
import com.tesco.bootcamp.orderreview.representations.OrderStatus;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderReviewController {

    private final OrderReviewService orderReviewService;

    @Autowired
    public OrderReviewController(OrderReviewService orderReviewService) {
        this.orderReviewService = orderReviewService;
    }

    @RequestMapping("/order-review")
    public void getOrdersToReview(Model model,
                                  @RequestParam(value = "loginID", required = true) String loginID) {

        Customer customer = orderReviewService.getCustomerName(loginID);

        int customerID = customer.getId();
        String customerName = customer.getCustomerName().getFullName();

        model.addAttribute("customerName", customerName);

        // Concatenate the Orders with their respective delivery status.
        List<CustomerOrderData> customerOrderData = new ArrayList<>();
        for (CustomerOrder i : orderReviewService.getOrderList(customerID)) {
            String orderId = i.getId();
            String orderStatus = orderReviewService.getOrderStatus(orderId).getStatus();
            customerOrderData.add(new CustomerOrderData(orderId, i.getProducts(), i.getOrderDateTime(), orderStatus));
        }

        model.addAttribute("customerOrderData", customerOrderData);
    }

}
