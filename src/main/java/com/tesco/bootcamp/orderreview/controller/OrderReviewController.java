package com.tesco.bootcamp.orderreview.controller;

import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderReviewController {

  @Autowired
  OrderReviewService orderReviewService;

  @RequestMapping("/order-review")
  public void getOrdersToReview(Model model,
      @RequestParam(value = "customerID", required = true) String customerID) {
    model.addAttribute("customerName", orderReviewService.getCustomerName(customerID));
  }
}
