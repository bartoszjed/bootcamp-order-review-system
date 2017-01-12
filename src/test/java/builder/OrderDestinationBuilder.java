package builder;

import com.tesco.bootcamp.orderreview.representations.OrderDestination;

/**
 * Created by manindrajha on 11/01/2017.
 */
public final class OrderDestinationBuilder {
    private double latitude;
    private double longitude;

    private OrderDestinationBuilder() {
    }

    public static OrderDestinationBuilder anOrderDestination() {
        return new OrderDestinationBuilder();
    }

    public OrderDestinationBuilder withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public OrderDestinationBuilder withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public OrderDestination build() {
        OrderDestination orderDestination = new OrderDestination(latitude, longitude);
        return orderDestination;
    }
}
