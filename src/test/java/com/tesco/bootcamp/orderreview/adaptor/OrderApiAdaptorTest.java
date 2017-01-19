package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class OrderApiAdaptorTest {

    private static final String ORDER_URL = "http://OrderUrl.com";
    private static final int CUSTOMER_ID = 3;
    private static final String CUSTOMER_FIRST_NAME = "Emily";
    private static final String ORDER_ID = "42b1ba80-b044-42c0-8e78-d653fc7581a4";

    private OrderApiAdaptor orderApiAdaptor;

    @Before
    public void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        orderApiAdaptor = new OrderApiAdaptor (ORDER_URL, restTemplate);
        MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();
        mockOrderService(server);
    }

    @Test
    public void shouldReturnValidCustomerOrderWhenCustomerIdIsPassed(){

        List<CustomerOrder> customerOrderList = orderApiAdaptor.call(CUSTOMER_ID);

        assertThat(customerOrderList.get(0).getId(), is(ORDER_ID));
        String firstName = customerOrderList.get(0).getCustomer().getCustomerName().getFirstName();
        assertThat(firstName, is(CUSTOMER_FIRST_NAME));

    }

    private void mockOrderService(MockRestServiceServer server) {
        server.expect(once(), requestTo(ORDER_URL + "/ghs/orders/customer?customerId=" + CUSTOMER_ID))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("[\n" +
                        "  {\n" +
                        "    \"id\": \"42b1ba80-b044-42c0-8e78-d653fc7581a4\",\n" +
                        "    \"customer\": {\n" +
                        "      \"id\": 3,\n" +
                        "      \"name\": {\n" +
                        "        \"firstName\": \"Emily\",\n" +
                        "        \"surname\": \"Hunter\"\n" +
                        "      }\n" +
                        "    },\n" +
                        "    \"orderDestination\": {\n" +
                        "      \"latitude\": 51.613453,\n" +
                        "      \"longitude\": -0.112499\n" +
                        "    },\n" +
                        "    \"products\": [\n" +
                        "      {\n" +
                        "        \"name\": \"BUTTER\",\n" +
                        "        \"category\": \"DIARY\"\n" +
                        "      },\n" +
                        "      {\n" +
                        "        \"name\": \"VODKA\",\n" +
                        "        \"category\": \"ALCOHOL\"\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"orderDateTime\": \"2017-01-12T20:00:00.000+0000\"\n" +
                        "  }\n" +
                        "]", MediaType.APPLICATION_JSON));
    }
}
