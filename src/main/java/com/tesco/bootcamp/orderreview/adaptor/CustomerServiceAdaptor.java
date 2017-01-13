package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Bartosz Jedrzejczak on 11/01/2017.
 */

@Component
@EnableAutoConfiguration

public class CustomerServiceAdaptor {

    private String customerApiURi;

    @Autowired
    public CustomerServiceAdaptor(@Qualifier("customerServiceURL") String url) {
        this.customerApiURi = url;
    }

    public Customer call(String loginID) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<Customer> collectRequestResult = restTemplate.exchange(
                    customerApiURi + "/customer?login=" + loginID + "&password=Password!23",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<Customer>() {
                    });
            return collectRequestResult.getBody();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
