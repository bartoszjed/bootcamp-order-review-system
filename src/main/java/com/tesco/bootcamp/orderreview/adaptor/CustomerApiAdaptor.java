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

@Component
@EnableAutoConfiguration

public class CustomerApiAdaptor {

    private final String customerApiUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public CustomerApiAdaptor(@Qualifier("customerServiceURL") String url,
                              @Qualifier("restTemplate") RestTemplate restTemplate) {
        this.customerApiUrl = url;
        this.restTemplate = restTemplate;
    }

    public Customer call(String loginID) {
        try {
            ResponseEntity<Customer> collectRequestResult = restTemplate.exchange(
                    customerApiUrl + "/customer?login=" + loginID + "&password=Password!23",
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
