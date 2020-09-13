package main.java;
import java.util.*;
import java.util.Map.Entry;

import static java.lang.Double.*;


/**
 * @author Nilay Dhamecha (dhamecha@arezzosky.com)
 */
public class Receipt {
    private Map<Product, Long> productVsQuantity = new HashMap<>();

    public Map<Product, Long> getProductVsQuantity() {
        return productVsQuantity;
    }

    public void setProductVsQuantity(Map<Product, Long> productVsQuantity) {
        this.productVsQuantity = productVsQuantity;
    }

    public Map<Product, Long> addProducts(List<Product> productsToAdd) {
        Set<Product> products = new HashSet<>();
        productsToAdd.forEach(p -> {
           if (products.add(p)) {
               productVsQuantity.put(p, 1L);
           } else {
               Long productQuantity = productVsQuantity.get(p);
               productVsQuantity.put(p, productQuantity + 1L);
           }
        });
        return productVsQuantity;
    }

    public double getTotalTax(Receipt receipt) {
        double totalTax = 0;
        Set<Entry<Product, Long>> allProducts = receipt.getProductVsQuantity().entrySet();
        for (Entry<Product, Long> product : allProducts) {
            double productTax = product.getKey().getProductPrice() * parseDouble(product.getKey().getCategory().getTax()) / 100 * product.getValue();
            totalTax = totalTax + productTax;
        }
        return totalTax;
    }

    public long getTotalPrice(Receipt receipt) {
        long totalPrice = 0L;
        Set<Entry<Product, Long>> allProducts = receipt.getProductVsQuantity().entrySet();
        for (Entry<Product, Long> product : allProducts) {
            long productPrice = (product.getKey().getProductPrice()) * product.getValue();
            totalPrice = totalPrice + productPrice;
        }
        return totalPrice;
    }
}
