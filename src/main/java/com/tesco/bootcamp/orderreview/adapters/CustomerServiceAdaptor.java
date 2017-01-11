package com.tesco.bootcamp.orderreview.adapters;

import com.tesco.bootcamp.orderreview.representations.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Bartosz Jedrzejczak on 11/01/2017.
 */

@Component
public class CustomerServiceAdaptor {


    private String customerApiURi = null;

    public CustomerServiceAdaptor() {
//        this.customerApiURi = null;
    }

    @Autowired
    public CustomerServiceAdaptor(@Qualifier("customerServiceURL") String url){
        this.customerApiURi = url;

   }

    public String call(String customerID) {
        RestTemplate restTemplate = new RestTemplate();

        try{
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