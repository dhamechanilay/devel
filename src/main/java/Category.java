package main.java;

/**
 * @author Nilay Dhamecha (dhamecha@arezzosky.com)
 */
public enum Category {
    CATEGORY_A("10"),
    CATEGORY_B("20"),
    CATEGORY_C("0");

    private final String tax;

    Category(String tax) {
        this.tax = tax;
    }

    public String getTax() {
        return this.tax;
    }

}
