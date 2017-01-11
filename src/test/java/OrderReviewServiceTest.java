import com.tesco.bootcamp.orderreview.adapters.CustomerServiceAdaptor;
import com.tesco.bootcamp.orderreview.controller.OrderReviewController;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.ui.Model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrderReviewServiceTest {

//  private Object url;

//    public static final String CUSTOMER_NAME_FIELD_ID = "customerName";
    public static final String CUSTOMER_NAME = "MR B";
    public static final String CUSTOMER_ID = "123434";

    @Mock
    CustomerServiceAdaptor adapter;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Test
  public void shouldReturnCustomerNameWhenCustomerIDIsPassed() {


//    //Given
//    OrderReviewService adapter = new OrderReviewService("http://customers.dev-environment.tesco.codurance.io:8080");
//    //When
//    String customerID="BethJohnston5";
//    //Then
//    assertThat(adapter.getCustomerName(customerID),is("Beth Johnston"));



      //Given (mocking conditions)
      Mockito.when(adapter.call(CUSTOMER_ID)).thenReturn(CUSTOMER_NAME);
      OrderReviewService orderReviewService = new OrderReviewService(adapter);

      //When
      String expectedName = orderReviewService.getCustomerName(CUSTOMER_ID);

      //Then
      Mockito.verify(adapter).call(CUSTOMER_ID);   //verifies if the mock was called with given customer_id
      assertThat(expectedName, is(CUSTOMER_NAME));

  }

}
