package com.tesco.bootcamp.orderreview.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by manindrajha on 11/01/2017.
 */
public class OrderDestination {

    private double latitude;
    private double longitude;

    @JsonCreator
    public OrderDestination(@JsonProperty("latitude") double latitude, @JsonProperty("longitude") double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
