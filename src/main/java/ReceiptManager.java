package main.java;
import main.java.model.Item;
import main.java.model.Product;

import java.util.*;
import static java.lang.Double.*;


/**
 * @author Nilay Dhamecha
 * Manager to manage the items.
 */
public class ReceiptManager {
    private List<Item> items = new ArrayList<>();

    public List<Item> getItems() {
        return items;
    }

    public List<Item> addProducts(List<Product> productsToAdd) {
        Set<Product> products = new HashSet<>();
        productsToAdd.forEach(p -> {
           if (products.add(p)) {
               items.add(new Item(p, 1L));
           } else {
               Item item = items.stream().filter(i -> i.getProduct().equals(p)).findFirst().get();
               Long productQuantity = item.getQuantity();
               items.add(new Item(p, productQuantity + 1L));
           }
        });
        return items;
    }

    public double getTotalTax() {
        double totalTax = 0;
        List<Item> items = getItems();
        for (Item item : items) {
            double productTax = item.getProduct().getProductPrice() * parseDouble(item.getProduct().getCategory().getTax()) / 100 * item.getQuantity();
            totalTax = totalTax + productTax;
        }
        return totalTax;
    }

    public long getTotalPrice() {
        long totalPrice = 0L;
        List<Item> items = getItems();
        for (Item item : items) {
            long productPrice = (item.getProduct().getProductPrice()) * item.getQuantity();
            totalPrice = totalPrice + productPrice;
        }
        return totalPrice;
    }
}
