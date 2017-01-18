package builder;

import com.tesco.bootcamp.orderreview.representations.Product;

public final class ProductBuilder {
    private String name = "Apple Pie";
    private String category = "Cakes";

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
        return new Product(name, category);
    }
}
