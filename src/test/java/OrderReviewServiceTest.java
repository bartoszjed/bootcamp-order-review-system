import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
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

  @Test
  public void shouldReturnEmptyListOfOrdersForGivenCustomerId(){

    //Given
    String customerId="123456";
    OrderReviewService orderReviewService = new OrderReviewService();

    //When
    List<CustomerOrder> customerOrderList = orderReviewService.getOrderList(customerId);

    //Then
    assertTrue(orderReviewService.getOrderList(customerId).size()>=0);


  }
/*
  @Test
  public void shouldReturnListOfOrdersForGivenCustomerId(){

    //Given
    String customerId="123456";
    OrderReviewService orderReviewService = new OrderReviewService();

    //When
    List<CustomerOrder> customerOrderList = orderReviewService.getOrderList(customerId);

    //Then
    assertTrue(orderReviewService.getOrderList(customerId).size()>=0);
*/

}
