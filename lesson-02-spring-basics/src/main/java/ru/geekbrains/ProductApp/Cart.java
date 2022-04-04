package ru.geekbrains.ProductApp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

public class Cart {
    private HashMap<Long, Product> productsInCart = new HashMap<>();

    public Cart() {
    }

    public HashMap<Long, Product> getProductsInCart() {
        return productsInCart;
    }

}
