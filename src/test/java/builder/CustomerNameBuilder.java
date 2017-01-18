package builder;

import com.tesco.bootcamp.orderreview.representations.CustomerName;

public final class CustomerNameBuilder {
    private String firstName = "Joe";
    private String surname = "Blogs";

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
        return new CustomerName(firstName, surname);
    }
}
