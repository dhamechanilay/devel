package test.java;

import main.java.model.Category;
import main.java.model.Item;
import main.java.model.Product;
import main.java.ReceiptManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.*;

/**
 * @author Nilay Dhamecha
 */
public class ReceiptManagerTest {
    @InjectMocks
    private ReceiptManager receiptManager;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addProductsTest() {
        List<Product> products = getProducts();
        List<Item> addedProducts = receiptManager.addProducts(products);
        assertProducts(addedProducts, products);
    }

    private List<Product> getProducts() {
        Product p1 = new Product("A1", "Laptop", 50000L, Category.A);
        Product p2 = new Product("B1", "Mouse", 1000L, Category.A);
        Product p3 = new Product("C1", "Jeans", 500L, Category.B);
        Product p4 = new Product("D1", "Water Bottle", 150L, Category.C);
        return Arrays.asList(p1, p2, p3, p4);
    }

    @Test
    public void getTotalTaxTest() {
        ReceiptManager receiptManager = new ReceiptManager();
        receiptManager.addProducts(getProducts());
        double totalTax = receiptManager.getTotalTax();
        Assert.assertEquals(5200, totalTax, 0.0);
    }

    @Test
    public void getTotalPriceTest() {
        ReceiptManager receiptManager = new ReceiptManager();
        receiptManager.addProducts(getProducts());
        double totalPrice = receiptManager.getTotalPrice();
        Assert.assertEquals(51650, totalPrice, 0.0);
    }

    private void assertProducts(List<Item> addedProducts, List<Product> products) {
        Assert.assertEquals(addedProducts.size(), products.size());
        Assert.assertEquals(addedProducts.get(0).getProduct(), products.get(0));
        Assert.assertEquals(addedProducts.get(1).getProduct(), products.get(1));
        Assert.assertEquals(addedProducts.get(2).getProduct(), products.get(2));
        Assert.assertEquals(addedProducts.get(3).getProduct(), products.get(3));

    }

}
