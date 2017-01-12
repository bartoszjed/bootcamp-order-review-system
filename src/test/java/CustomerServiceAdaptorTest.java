import com.tesco.bootcamp.orderreview.adaptor.CustomerServiceAdaptor;
import com.tesco.bootcamp.orderreview.adaptor.DummyOrderSystemAdaptor;
import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by maheshnakum on 12/01/2017.
 */
public class CustomerServiceAdaptorTest {


    public static final String CUSTOMER_NAME = "Ellie Hill";
    public static final String LOGIN_ID = "EllieHill3";
    public static final String CUSTOMER_SERVICE_URL = "http://customers.dev-environment.tesco.codurance.io:8080";

    @Test
    public void shouldReturnValidCustomerNameWhenCustomerLoginIDIsPassed() {

        //Given
        CustomerServiceAdaptor customerServiceAdaptor = new CustomerServiceAdaptor(CUSTOMER_SERVICE_URL);
        DummyOrderSystemAdaptor dummyOrderSystemAdaptor = new DummyOrderSystemAdaptor();
        OrderReviewService orderReviewService =
                new OrderReviewService(customerServiceAdaptor, dummyOrderSystemAdaptor);

        //When
        Customer expectedCustomer = orderReviewService.getCustomerName(LOGIN_ID);
        String customerName = expectedCustomer.getCustomerName().getFullName();
        
        //Then
        assertThat(customerName, is(CUSTOMER_NAME));
    }
}