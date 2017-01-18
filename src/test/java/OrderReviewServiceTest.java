import builder.CustomerOrderBuilder;
import com.tesco.bootcamp.orderreview.adaptor.CustomerApiAdaptor;
import com.tesco.bootcamp.orderreview.adaptor.OrderApiAdaptor;
import com.tesco.bootcamp.orderreview.adaptor.OrderStatusApiAdaptor;
import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerName;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrderReviewServiceTest {

    public static final Customer CUSTOMER = new Customer(1, new CustomerName("Joe", "Blogs"));
    public static final String LOGIN_ID = "123434";
    public static final int CUSTOMER_ID = 12;

    @Mock
    CustomerApiAdaptor customerApiAdaptor;

    @Mock
    OrderApiAdaptor orderApiAdaptor;

    @Mock
    OrderStatusApiAdaptor orderStatusApiAdaptor;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private OrderReviewService orderReviewService;

    @Before
    public void setUp(){
        orderReviewService = new OrderReviewService(customerApiAdaptor, orderApiAdaptor, orderStatusApiAdaptor);
    }

    @Test
    public void shouldReturnCustomerNameWhenCustomerIDIsPassed() {

        //Given (mocking conditions)
        Mockito.when(customerApiAdaptor.call(LOGIN_ID)).thenReturn(CUSTOMER);

        //When
        Customer expectedCustomer = orderReviewService.getCustomerName(LOGIN_ID);

        //Then
        Mockito.verify(customerApiAdaptor).call(LOGIN_ID);   //verifies if the mock was called with given customer_id
        assertThat(expectedCustomer, is(CUSTOMER));
    }

    @Test
    public void shouldReturnListOfOrdersForGivenCustomerId() {

        //Given
        CustomerOrder customerOrderDummy = CustomerOrderBuilder.aCustomerOrder()
                .build();
        List<CustomerOrder> customerOrderListDummy = new ArrayList<>();
        customerOrderListDummy.add(customerOrderDummy);
        Mockito.when(orderApiAdaptor.call(CUSTOMER_ID))
                .thenReturn(new ArrayList<>())
                .thenReturn(customerOrderListDummy);

        //When
        List<CustomerOrder> firstOrderList = orderReviewService.getOrderList(CUSTOMER_ID);
        List<CustomerOrder> secondOrderList = orderReviewService.getOrderList(CUSTOMER_ID);


        //Then
        assertTrue(firstOrderList.size() == 0);
        assertTrue(secondOrderList.size() > 0);
    }
}
