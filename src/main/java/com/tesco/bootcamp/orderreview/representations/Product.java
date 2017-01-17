package com.tesco.bootcamp.orderreview.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    private final String name;
    private final String category;

    @JsonCreator
    public Product(@JsonProperty("name") String name,
                   @JsonProperty("category") String category) {
        this.category = category;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }
}
