package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class OrderStatusAPIAdaptor {

    private String orderStatusAPIURI;

    @Autowired
    public OrderStatusAPIAdaptor(@Qualifier("orderStatusServiceURL") String url) {
        this.orderStatusAPIURI = url;
    }

    public OrderStatus call(String orderId) {
        RestTemplate restTemplate = new RestTemplate();

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
