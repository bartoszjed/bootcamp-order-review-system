package builder;

import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerOrder;
import com.tesco.bootcamp.orderreview.representations.OrderDestination;
import com.tesco.bootcamp.orderreview.representations.Product;

import java.util.ArrayList;
import java.util.List;

public final class CustomerOrderBuilder {
    private String id = "a7291e84-0802-41fc-b899-300fcefa3b51";
    private Customer customer;
    private List<Product> productList = new ArrayList<>();
    private OrderDestination orderDestination;
    private String orderDateAndTime = "2017-01-12T20:00:00.000+0000";

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
