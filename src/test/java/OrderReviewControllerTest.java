import com.tesco.bootcamp.orderreview.controller.OrderReviewController;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.ui.Model;

public class OrderReviewControllerTest {

  public static final String CUSTOMER_NAME_FIELD_ID = "customerName";
  public static final String CUSTOMER_NAME = "Mr Richy";
  public static final String CUSTOMER_ID = "123434";

  @Mock
  OrderReviewService orderReviewService;

  @Mock
  Model model;

  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @Test
  public void shouldGetCustomerNameWhenGetOrderReviewIsCalled() {

    //Given
    OrderReviewController orderReviewController = new OrderReviewController(orderReviewService);

    //When
    Mockito.when(orderReviewService.getCustomerName(CUSTOMER_ID)).thenReturn(CUSTOMER_NAME);

    //Then
    orderReviewController.getOrdersToReview(model, CUSTOMER_ID);
    Mockito.verify(orderReviewService).getCustomerName(CUSTOMER_ID);
    Mockito.verify(model).addAttribute(CUSTOMER_NAME_FIELD_ID, orderReviewService.getCustomerName(CUSTOMER_ID));
  }

}
