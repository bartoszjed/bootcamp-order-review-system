package builder;

import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerName;

public final class CustomerBuilder {
    private int id = 15;
    private CustomerName customerName;

    private CustomerBuilder() {
    }

    public static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    public CustomerBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public CustomerBuilder withCustomerName(CustomerName customerName) {
        this.customerName = customerName;
        return this;
    }

    public Customer build() {
        return new Customer(id, customerName);
    }
}
