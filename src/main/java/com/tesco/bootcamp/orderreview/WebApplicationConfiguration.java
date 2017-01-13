package com.tesco.bootcamp.orderreview;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by Bartosz Jedrzejczak on 11/01/2017.
 */
@Configuration
public class WebApplicationConfiguration {

    @Value("${customerAPI.url}")
    private String customerServiceURL;

    @Bean(name = "customerServiceURL")
    public String customerServiceURLMethod(){
        return customerServiceURL;
    }



    @Value("${orderAPI.url}")
    private String orderServiceURL;

    @Bean(name = "orderServiceURL")
    public String orderServiceURLMethod(){
        return orderServiceURL;
    }



    @Value("${orderStatusAPI.url}")
    private String orderStatusServiceURL;

    @Bean(name = "orderStatusServiceURL")
    public String orderStatusServiceURLMethod(){
        return orderStatusServiceURL;
    }



    @Bean(name = "dummy")
    @Primary
    public String dummy(){
        return "";
    }
}
