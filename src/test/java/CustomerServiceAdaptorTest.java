/**
 * Created by maheshnakum on 12/01/2017.
 */
public class CustomerServiceAdaptorTest {


    public static final String CUSTOMER_NAME = "Ellie Hill";
    public static final String LOGIN_ID = "EllieHill3";
    public static final String CUSTOMER_SERVICE_URL = "http://customers.dev-environment.tesco.codurance.io:8080";


//    @Mock
//    RestTemplate restTemplate;
//
//    @Rule
//    public MockitoRule mockitoRule = MockitoJUnit.rule();


//    @Test
//    public void shouldReturnValidCustomerNameWhenCustomerLoginIDIsPassed() {
//
//        //Given
//        CustomerServiceAdaptor customerServiceAdaptor = new CustomerServiceAdaptor(CUSTOMER_SERVICE_URL);
//        //OrderSystemAdaptor orderSystemAdaptor = new OrderSystemAdaptor();
//
//        //temporary used DummyOrderSystemAdaptor to instantiate the OrderReviewService
//        DummyOrderSystemAdaptor dummyOrderSystemAdaptor = new DummyOrderSystemAdaptor();
//        OrderReviewService orderReviewService =
//                new OrderReviewService(customerServiceAdaptor, dummyOrderSystemAdaptor);
//
//        //When
//        Customer expectedCustomer = orderReviewService.getCustomerName(LOGIN_ID);
//        String customerName = expectedCustomer.getCustomerName().getFullName();
//
//        //Then
//        assertThat(customerName, is(CUSTOMER_NAME));
//    }

//    @Test
//    public void shouldReturnValidCustomerNameWhenCustomerLoginIDIsPassedNew() {
//
//        RestTemplate restTemplate = new RestTemplate()
//        MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();
//
//        server.expect(manyTimes(), requestTo("EllieHill3")).andExpect(method(HttpMethod.GET))
//                .andRespond(withSuccess("{ \"id\" : \"3\", \"name\" : \"Ellie Hill\"}", MediaType.APPLICATION_JSON));
//
//        //Hotel hotel = restTemplate.getForObject("/hotels/{id}", Hotel.class, 42);
//        // Use the hotel instance...
//
//        // Verify all expectations met
//        server.verify();
//    }
}