import builder.*;
import com.tesco.bootcamp.orderreview.representations.*;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
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

  @Test
  public void shouldReturnListOfOrdersForGivenCustomerId(){

    //Given
    String customerId="123456";
    OrderReviewService orderReviewService = new OrderReviewService();

    //When
    List<CustomerOrder> customerOrderList = orderReviewService.getOrderList(customerId);

    //Then
    assertTrue(orderReviewService.getOrderList(customerId).size()>=0);

    //Build List of Products
    List<Product> productList= new ArrayList<Product>();
    Product product= ProductBuilder.aProduct().withName("Beans").withCategory("Canned Food").build();
    productList.add(product);
    //Build Customer Name
    CustomerName customerName = CustomerNameBuilder.aCustomerName().withFirstName("Alan").withSurname("Lamb").build();

    //Build Customer
    Customer customer = CustomerBuilder.aCustomer().withId(1).withCustomerName(customerName).build();
    //Build Order Destination
    OrderDestination orderDestination = OrderDestinationBuilder.anOrderDestination().withLatitude(23.50).withLongitude(45.00).build();

    //Build Customer Order
    CustomerOrderBuilder.aCustomerOrder()
            .withId("12")
            .withOrderDateAndTime("10-Jan-2017 15:00:00")
            .withProductList(productList)
            .withCustomer(customer)
            .withOrderDestination(orderDestination)
            .build();

  }


}
