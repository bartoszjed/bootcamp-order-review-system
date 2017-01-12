package com.tesco.bootcamp.orderreview.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maheshnakum on 11/01/2017.
 */
public class CustomerName {

    private String firstName;
    private String surname;

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
