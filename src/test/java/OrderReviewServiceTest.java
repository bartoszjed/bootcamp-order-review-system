import com.tesco.bootcamp.orderreview.adapters.CustomerServiceAdaptor;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrderReviewServiceTest {

    public static final String CUSTOMER_NAME = "MR B";
    public static final String LOGIN_ID = "123434";

    @Mock
    CustomerServiceAdaptor adapter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Test
  public void shouldReturnCustomerNameWhenCustomerIDIsPassed() {

      //Given (mocking conditions)
      Mockito.when(adapter.call(LOGIN_ID)).thenReturn(CUSTOMER_NAME);
      OrderReviewService orderReviewService = new OrderReviewService(adapter);

      //When
      String expectedName = orderReviewService.getCustomerName(LOGIN_ID);

      //Then
      Mockito.verify(adapter).call(LOGIN_ID);   //verifies if the mock was called with given customer_id
      assertThat(expectedName, is(CUSTOMER_NAME));

  }

}
