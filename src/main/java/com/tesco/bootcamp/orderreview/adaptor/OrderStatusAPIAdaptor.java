package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderStatusAPIAdaptor {

    private String orderStatusAPIURI;
    private RestTemplate restTemplate;

    @Autowired
    public OrderStatusAPIAdaptor(@Qualifier("orderStatusServiceURL") String url,
                                 @Qualifier("restTemplate") RestTemplate restTemplate) {
        this.orderStatusAPIURI = url;
        this.restTemplate = restTemplate;
    }

    public OrderStatus call(String orderId) {
        //RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<OrderStatus> collectRequestResult = restTemplate.exchange(
                    orderStatusAPIURI + "/order-status?orderId=" + orderId,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<OrderStatus>() {
                    });
            return collectRequestResult.getBody();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
