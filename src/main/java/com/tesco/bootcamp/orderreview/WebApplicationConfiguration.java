package com.tesco.bootcamp.orderreview;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bartosz Jedrzejczak on 11/01/2017.
 */
@Configuration
public class WebApplicationConfiguration {

    @Value("${customerAPi.url}")
    private String customerServiceURL;

    @Bean(name = "customerServiceURL")
    public String customerServiceURLMethod(){
        return customerServiceURL;
    }



}
