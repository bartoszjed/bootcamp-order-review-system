package com.tesco.bootcamp.orderreview.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by manindrajha on 11/01/2017.
 */
public class Product {

    private String name;
    private String category;

    @JsonCreator
    public Product(@JsonProperty("category") String category, @JsonProperty("name") String name) {
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
