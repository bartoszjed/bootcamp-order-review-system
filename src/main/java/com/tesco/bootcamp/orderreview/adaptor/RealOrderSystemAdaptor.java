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
public class RealOrderSystemAdaptor implements OrderSystemAdaptor{

    private String orderAPIUrl;

    @Autowired
    public RealOrderSystemAdaptor(@Qualifier("orderServiceURL") String url) {
        this.orderAPIUrl = url;
    }

    public List<CustomerOrder> call(int customerId) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            ResponseEntity<List<CustomerOrder>> collectRequestResult = restTemplate.exchange(
                    orderAPIUrl + "/ghs/orders/customer?customerId=" + customerId,
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

