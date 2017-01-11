package com.tesco.bootcamp.orderreview.service;

import com.tesco.bootcamp.orderreview.representations.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderReviewService {

    private final String customerApiURi;

    @Autowired
    public OrderReviewService(@Qualifier("customerServiceURL") String url){
        this.customerApiURi = url;
    }


    public String getCustomerName(String customerID) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<Customer> collectRequestResult = restTemplate.exchange(
                    customerApiURi+"/customer?login=" + customerID+"&password=Password!23",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Customer>() {
                    });
            return collectRequestResult.getBody().getCustomerName().toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
