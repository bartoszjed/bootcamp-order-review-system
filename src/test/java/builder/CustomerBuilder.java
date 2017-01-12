package builder;

import com.tesco.bootcamp.orderreview.representations.Customer;
import com.tesco.bootcamp.orderreview.representations.CustomerName;

/**
 * Created by manindrajha on 11/01/2017.
 */
public final class CustomerBuilder {
    private int id;
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
        Customer customer = new Customer(id, customerName);
        return customer;
    }
}
