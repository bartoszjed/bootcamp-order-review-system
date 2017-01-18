package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.representations.OrderStatus;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


public class OrderStatusApiAdaptorTest {

    private static final String ORDER_STATUS_URL = "http://OrderStatusUrl.com";
    private static final String ORDER_ID = "a7291e84-0802-41fc-b899-300fcefa3b51";

    private OrderStatusApiAdaptor orderStatusApiAdaptor;

    @Before
    public void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        orderStatusApiAdaptor = new OrderStatusApiAdaptor(ORDER_STATUS_URL, restTemplate);
        MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();
        mockOrderStatusService(server);
    }

    @Test
    public void shouldReturnValidCustomerOrderStatusWhenPassedAnOrderId() {

        OrderStatus returnedOrderStatus = orderStatusApiAdaptor.call(ORDER_ID);

        assertThat(returnedOrderStatus.getOrderId(), is(ORDER_ID));
        assertThat(returnedOrderStatus.getStatus(), is("Delivered"));

    }

    private void mockOrderStatusService(MockRestServiceServer server) {
        server.expect(once(), requestTo(ORDER_STATUS_URL + "/order-status?orderId=" + ORDER_ID))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{\n" +
                        "  \"orderId\":\"a7291e84-0802-41fc-b899-300fcefa3b51\",\n" +
                        "  \"status\":\"Delivered\"\n" +
                        "}", MediaType.APPLICATION_JSON));
    }
}
