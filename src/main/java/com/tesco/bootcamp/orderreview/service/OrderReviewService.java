package com.tesco.bootcamp.orderreview.service;

import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@Configuration
public class OrderReviewService {

    @Value("${customerAPi.url}")
    private String customerAPiURi;


    public String getCustomerName(String customerID) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Customer> collectRequestResult = restTemplate.exchange(
                    customerAPiURi+"/customer?login=" + customerID+"&password=Password!23",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Customer>() {
                    });
            return collectRequestResult.getBody().getCustomerName().toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<CustomerOrder> getOrderList(String customerID){
        List<CustomerOrder> listCustomer = new ArrayList<>();

        return listCustomer;

    }
}
