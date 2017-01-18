package com.tesco.bootcamp.orderreview.controller;

import com.tesco.bootcamp.orderreview.controller.OrderReviewController;
import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerName;
import com.tesco.bootcamp.orderreview.service.OrderReviewService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.ui.Model;

public class OrderReviewControllerTest {

  public static final String CUSTOMER_NAME_FIELD_ID = "customerName";
  public static final Customer CUSTOMER = new Customer(1, new CustomerName("Joe", "Blogs"));
  public static final String CUSTOMER_FULL_NAME = CUSTOMER.getCustomerName().getFullName();
  public static final String LOGIN_ID = "123434";

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
    Mockito.when(orderReviewService.getCustomerName(LOGIN_ID)).thenReturn(CUSTOMER);

    //When
    orderReviewController.getOrdersToReview(model, LOGIN_ID);

    //Then
    Mockito.verify(orderReviewService).getCustomerName(LOGIN_ID);
    Mockito.verify(model).addAttribute(CUSTOMER_NAME_FIELD_ID, CUSTOMER_FULL_NAME);
  }

}
