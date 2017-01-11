package builder;

import com.tesco.bootcamp.orderreview.representations.CustomerName;

/**
 * Created by manindrajha on 11/01/2017.
 */
public final class CustomerNameBuilder {
    private String firstName;
    private String surname;

    private CustomerNameBuilder() {
    }

    public static CustomerNameBuilder aCustomerName() {
        return new CustomerNameBuilder();
    }

    public CustomerNameBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerNameBuilder withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public CustomerName build() {
        CustomerName customerName = new CustomerName(firstName, surname);
        return customerName;
    }
}
