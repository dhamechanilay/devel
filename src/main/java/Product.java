package main.java;

import java.util.Objects;

/**
 * @author Nilay Dhamecha (dhamecha@arezzosky.com)
 */
public class Product {
    private String productId;
    private String productName;
    private Long productPrice;
    private Category category;

    public Product(String productId, String productName, Long productPrice, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getProductId().equals(product.getProductId()) &&
                getProductName().equals(product.getProductName()) &&
                getProductPrice().equals(product.getProductPrice()) &&
                getCategory() == product.getCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getProductPrice(), getCategory());
    }
}
