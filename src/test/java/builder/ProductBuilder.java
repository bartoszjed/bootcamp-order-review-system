package builder;

import com.tesco.bootcamp.orderreview.representations.Product;

/**
 * Created by manindrajha on 11/01/2017.
 */
public final class ProductBuilder {
    private String name;
    private String category;

    private ProductBuilder() {
    }

    public static ProductBuilder aProduct() {
        return new ProductBuilder();
    }

    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withCategory(String category) {
        this.category = category;
        return this;
    }

    public Product build() {
        Product product = new Product(name, category);
        return product;
    }
}
