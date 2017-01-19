package com.tesco.bootcamp.orderreview;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

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



    @SuppressWarnings("SameReturnValue")
    @Bean(name = "dummy")
    @Primary
    public String dummy(){
        return "";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(clientHttpRequestFactory());
    }

    private ClientHttpRequestFactory clientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(5000);
        return factory;
    }

}
