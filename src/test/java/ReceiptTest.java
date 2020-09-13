package test.java;

import main.java.Category;
import main.java.Product;
import main.java.Receipt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.*;

/**
 * @author Nilay Dhamecha (dhamecha@arezzosky.com)
 */
public class ReceiptTest {
    @InjectMocks
    private Receipt receipt;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addProductsTest() {
        List<Product> products = getProducts();
        Map<Product, Long> addedProducts = receipt.addProducts(products);
        assertProducts(addedProducts, products);
    }

    private List<Product> getProducts() {
        Product p1 = new Product("A1", "Laptop", 50000L, Category.CATEGORY_A);
        Product p2 = new Product("B1", "Mouse", 1000L, Category.CATEGORY_A);
        Product p3 = new Product("C1", "Jeans", 500L, Category.CATEGORY_B);
        Product p4 = new Product("D1", "Water Bottle", 150L, Category.CATEGORY_C);
        return Arrays.asList(p1, p2, p3, p4);
    }

    @Test
    public void getTotalTaxTest() {
        Receipt receipt = new Receipt();
        receipt.setProductVsQuantity(getProductVsQuantityMap());
        double totalTax = receipt.getTotalTax(receipt);
        Assert.assertEquals(5200, totalTax, 0.0);
    }

    @Test
    public void getTotalPriceTest() {
        Receipt receipt = new Receipt();
        receipt.setProductVsQuantity(getProductVsQuantityMap());
        double totalPrice = receipt.getTotalPrice(receipt);
        Assert.assertEquals(52000, totalPrice, 0.0);
    }

    private Map<Product, Long> getProductVsQuantityMap() {
        Map<Product, Long> productVsQuantity = new HashMap<>();
        productVsQuantity.put(new Product("A1", "Laptop", 50000L, Category.CATEGORY_A), 1L);
        productVsQuantity.put(new Product("B1", "Mouse", 1000L, Category.CATEGORY_A), 2L);
        return productVsQuantity;
    }

    private void assertProducts(Map<Product, Long> addedProducts, List<Product> products) {
        Set<Product> allProducts = addedProducts.keySet();
        Assert.assertTrue(allProducts.containsAll(products));
    }

}
