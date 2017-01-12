import com.tesco.bootcamp.orderreview.adapters.CustomerServiceAdaptor;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by maheshnakum on 12/01/2017.
 */
public class CustomerServiceAdaptorTest {

    public static final String LOGIN_ID = "EllieHill3";
    public static final String INVALID_LOGIN_ID = "Mahesh";
    public static final String CUSTOMER_NAME = "Ellie Hill";
    public static final String CUSTOMER_SERVICE_URL = "http://customers.dev-environment.tesco.codurance.io:8080";

    @Test
    public void shouldReturnValidCustomerNameWhenCustomerLoginIDIsPassed() {

        //Given
        CustomerServiceAdaptor customerServiceAdaptor = new CustomerServiceAdaptor(CUSTOMER_SERVICE_URL);
        OrderReviewService orderReviewService = new OrderReviewService(customerServiceAdaptor);

        //When
        String expectedName = orderReviewService.getCustomerName(LOGIN_ID);

        //Then
        assertThat(expectedName, is(CUSTOMER_NAME));
    }

    @Test
    public void shouldReturnError401WhenInvalidCustomerLoginIDIsProvided() {

        //Given
        CustomerServiceAdaptor customerServiceAdaptor = new CustomerServiceAdaptor(CUSTOMER_SERVICE_URL);
        OrderReviewService orderReviewService = new OrderReviewService(customerServiceAdaptor);

        //When
        String expectedName = orderReviewService.getCustomerName(INVALID_LOGIN_ID);

        //Then
        assertThat(expectedName, is("Error: 401"));
    }
}