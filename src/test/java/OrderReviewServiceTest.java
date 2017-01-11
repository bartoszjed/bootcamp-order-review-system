import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import junit.framework.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrderReviewServiceTest {

  @Test
  public void shouldReturnCustomerNameWhenCustomerIDIsPassed() {
    //Given
    OrderReviewService orderReviewService = new OrderReviewService();
    //When
    String customerID="123456";
    //Then
    assertThat(orderReviewService.getCustomerName(customerID),is("Rich"));
  }

}
