package com.tesco.bootcamp.orderreview.service;

import com.tesco.bootcamp.orderreview.representations.Customer;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderReviewService {


    public String getCustomerName(String customerID) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Customer> collectRequestResult = restTemplate.exchange(
                    "http://customers.dev-environment.tesco.codurance.io:8080/customer?login=KayleighJohnston1&password=Password!23",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Customer>() {
                    });
            return collectRequestResult.getBody().getCustomerName().toString();
            //logger.info("Collecting parcels from the shop code: " + collectRequestResult.getStatusCode());


        } catch (Exception e) {
            //logger.error("Parcels cannot be collected from the shop", e);
            throw new RuntimeException("Parcels cannot be collected from the shop", e);
        }
    }

}
