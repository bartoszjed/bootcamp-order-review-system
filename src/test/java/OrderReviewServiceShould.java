import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OrderReviewServiceShould {

  @Test
  public void returnCustomerNameWhenCustomerIDIsPassed() {
    //Given
    OrderReviewService orderReviewService = new OrderReviewService("");
    //When
    String customerID="123456";
    //Then
    assertThat(orderReviewService.getCustomerName(customerID),is("Rich"));
  }

}
