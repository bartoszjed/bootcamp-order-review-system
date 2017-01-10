package com.tesco.bootcamp.orderreview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderReviewController {
    @RequestMapping("/order-review")
    public String getOrdersToReview(Model model, @RequestParam(value="customerID", required=true) String customerID) {
        model.addAttribute("customerID", customerID);
        return "order-review";
    }
}
