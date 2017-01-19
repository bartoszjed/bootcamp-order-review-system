package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Component
@EnableAutoConfiguration
public class OrderApiAdaptor{

    private final String orderApiUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderApiAdaptor(@Qualifier("orderServiceURL") String url,
                           @Qualifier("restTemplate") RestTemplate restTemplate) {
        this.orderApiUrl = url;
        this.restTemplate = restTemplate;
    }

    public List<CustomerOrder> call(int customerId) {

        try {
            ResponseEntity<List<CustomerOrder>> collectRequestResult = restTemplate.exchange(
                    orderApiUrl + "/ghs/orders/customer?customerId=" + customerId,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<CustomerOrder>>() {
                    });
            return collectRequestResult.getBody();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

