package com.tesco.bootcamp.orderreview.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerName {

    private final String firstName;
    private final String surname;

    @JsonCreator
    public CustomerName(@JsonProperty("firstName") String firstName, @JsonProperty("surname") String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return getFirstName() + " " + getSurname();
    }
}
