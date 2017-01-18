package com.tesco.bootcamp.orderreview.adaptor;

import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

public class CustomerApiAdaptorTest {

    public static final String CUSTOMER_NAME = "Anna Cooper";
    public static final String LOGIN_ID = "AnnaCooper1";
    public static final String CUSTOMER_SERVICE_URL = "http://CustomerService.coms";

    @Mock
    RestTemplate restTemplate;

    @Mock
    OrderApiAdaptor orderApiAdaptor;

    @Mock
    OrderStatusApiAdaptor orderStatusApiAdaptor;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void shouldReturnValidCustomerNameWhenCustomerLoginIDIsPassed() {

        //Given
        RestTemplate restTemplate = new RestTemplate();
        CustomerApiAdaptor customerApiAdaptor = new CustomerApiAdaptor(CUSTOMER_SERVICE_URL, restTemplate);
        MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();
        mockCustomerServiceCall(server);

        //When
        OrderReviewService orderReviewService = new OrderReviewService(customerApiAdaptor, orderApiAdaptor, orderStatusApiAdaptor);
        String expectedCustomerFullName = orderReviewService.getCustomerName(LOGIN_ID).getCustomerName().getFullName();

        //Then
        assertThat(expectedCustomerFullName, is(CUSTOMER_NAME));
    }

    private void mockCustomerServiceCall(MockRestServiceServer server) {
        server.expect(once(), requestTo(CUSTOMER_SERVICE_URL + "/customer?login=" + LOGIN_ID + "&password=Password!23"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"name\": {\n" +
                        "    \"firstName\": \"Anna\",\n" +
                        "    \"surname\": \"Cooper\"\n" +
                        "  }\n" +
                        "}", MediaType.APPLICATION_JSON));
    }
}