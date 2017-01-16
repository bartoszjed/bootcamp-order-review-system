package builder;

import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import com.tesco.bootcamp.orderreview.representations.OrderDestination;
import com.tesco.bootcamp.orderreview.representations.Product;

import java.util.List;

public final class CustomerOrderBuilder {
    private String id;
    private Customer customer;
    private List<Product> productList;
    private OrderDestination orderDestination;
    private String orderDateAndTime;

    private CustomerOrderBuilder() {
    }

    public static CustomerOrderBuilder aCustomerOrder() {
        return new CustomerOrderBuilder();
    }

    public CustomerOrderBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public CustomerOrderBuilder withCustomer(Customer customer) {
        this.customer = customer;
        return this;
    }

    public CustomerOrderBuilder withProductList(List<Product> productList) {
        this.productList = productList;
        return this;
    }

    public CustomerOrderBuilder withOrderDestination(OrderDestination orderDestination) {
        this.orderDestination = orderDestination;
        return this;
    }

    public CustomerOrderBuilder withOrderDateAndTime(String orderDateAndTime) {
        this.orderDateAndTime = orderDateAndTime;
        return this;
    }

    public CustomerOrder build() {
        return new CustomerOrder(id, customer, productList, orderDestination, orderDateAndTime);
    }
}
