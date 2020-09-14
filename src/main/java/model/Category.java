package main.java.model;

/**
 * @author Nilay Dhamecha
 * This enum determines the tax category of a product.
 */
public enum Category {
    A("10"),
    B("20"),
    C("0");

    private final String tax;

    Category(String tax) {
        this.tax = tax;
    }

    public String getTax() {
        return this.tax;
    }

}
