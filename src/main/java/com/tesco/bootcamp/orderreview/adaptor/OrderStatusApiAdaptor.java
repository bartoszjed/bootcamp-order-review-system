package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class OrderStatusApiAdaptor {

    private final String orderStatusApiUrl;
    private final RestTemplate restTemplate;

    @Autowired
    public OrderStatusApiAdaptor(@Qualifier("orderStatusServiceURL") String url,
                                 @Qualifier("restTemplate") RestTemplate restTemplate) {
        this.orderStatusApiUrl = url;
        this.restTemplate = restTemplate;
    }

    public OrderStatus call(String orderId) {
        //RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<OrderStatus> collectRequestResult = restTemplate.exchange(
                    orderStatusApiUrl + "/order-status?orderId=" + orderId,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<OrderStatus>() {
                    });
            return collectRequestResult.getBody();

        } catch (ResourceAccessException re) {
            return new OrderStatus(orderId, "Not available");

        } catch(HttpClientErrorException he2){
            return new OrderStatus(orderId, "Error: "+he2.getStatusCode());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
