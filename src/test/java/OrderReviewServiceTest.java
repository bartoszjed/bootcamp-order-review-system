import com.tesco.bootcamp.orderreview.adaptor.CustomerServiceAdaptor;
import com.tesco.bootcamp.orderreview.adaptor.OrderSystemAdaptor;
import com.tesco.bootcamp.orderreview.adaptor.OrderServiceAdaptor;
import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerName;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class OrderReviewServiceTest {

    public static final Customer CUSTOMER = new Customer(1, new CustomerName("Joe", "Blogs"));
    public static final String LOGIN_ID = "123434";
    public static final int CUSTOMER_ID = 12;

    @Mock
    CustomerServiceAdaptor customerServiceAdaptor;

    @Mock
    OrderSystemAdaptor orderSystemAdaptor;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void shouldReturnCustomerNameWhenCustomerIDIsPassed() {

        //Given (mocking conditions)
        Mockito.when(customerServiceAdaptor.call(LOGIN_ID)).thenReturn(CUSTOMER);
        OrderReviewService orderReviewService = new OrderReviewService(customerServiceAdaptor, orderSystemAdaptor);

        //When
        Customer expectedCustomer = orderReviewService.getCustomerName(LOGIN_ID);

        //Then
        Mockito.verify(customerServiceAdaptor).call(LOGIN_ID);   //verifies if the mock was called with given customer_id
        assertThat(expectedCustomer, is(CUSTOMER));

    }

    @Test
    public void shouldReturnEmptyListOfOrdersForGivenCustomerId() {

        //Given
        Mockito.when(orderSystemAdaptor.call(CUSTOMER_ID)).thenReturn(new ArrayList<CustomerOrder>());
        OrderReviewService orderReviewService = new OrderReviewService(customerServiceAdaptor, orderSystemAdaptor);

        //When
        List<CustomerOrder> customerOrderList = orderReviewService.getOrderList(CUSTOMER_ID);

        //Then
        assertTrue(orderReviewService.getOrderList(CUSTOMER_ID).size() == 0);
    }

    @Test
    public void shouldReturnListOfOrdersForGivenCustomerId() {

        //Given
        OrderReviewService orderReviewService = new OrderReviewService(customerServiceAdaptor, new OrderServiceAdaptor(""));

        //When
        List<CustomerOrder> customerOrderList = orderReviewService.getOrderList(CUSTOMER_ID);

        //Then
        assertTrue(orderReviewService.getOrderList(CUSTOMER_ID).size() > 0);
    }
}
