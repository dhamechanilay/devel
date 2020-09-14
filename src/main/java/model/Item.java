package main.java.model;

/**
 * @author Nilay Dhamecha
 * Model for product and its quantity.
 */
public class Item {
    private Product product;
    private Long quantity;

    public Item(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public Long getQuantity() {
        return quantity;
    }
}
