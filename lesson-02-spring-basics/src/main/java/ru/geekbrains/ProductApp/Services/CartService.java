package ru.geekbrains.ProductApp.Services;

import org.springframework.stereotype.Service;
import ru.geekbrains.ProductApp.Cart;
import ru.geekbrains.ProductApp.Product;
import ru.geekbrains.ProductApp.Repositories.ProductRepository;

import java.util.HashMap;
import java.util.List;

@Service
public class CartService {
    private Cart cart = new Cart();

    public CartService() {
    }

    public HashMap<Long, Product> getProductList() {
        return cart.getProductsInCart();
    }

    //Добавление одного продукта
    public void addProductToCart(Product product) {
        cart.getProductsInCart().put(product.getId(), product);
        System.out.println(product.getName() + " добавлен в корзину");
    }

    //Добавление множества продуктов
    public void addProductToCart(Product ... products) {
        for (Product product : products) {
            cart.getProductsInCart().put(product.getId(), product);
            System.out.println(product.getName() + " добавлен в корзину");
        }
    }

    //Извлечение продукта
    public void deleteProductFromCart(Product product) {
        if (cart.getProductsInCart().containsKey(product.getId())) {
            cart.getProductsInCart().remove(product.getId());
            System.out.println(product.getName() + " извлечён из корзину");
        } else {
            System.out.println("Такого товара нет в корзине");
        }
    }

    //Извлечение продукта по id
    public void deleteProductFromCart(long id) {
        if (cart.getProductsInCart().containsKey(id)) {
            cart.getProductsInCart().remove(id);
        } else {
            System.out.println("Такого товара нет в корзине");
        }
    }

    //Извлечение множества продуктов из корзины
    public void deleteProductFromCart(Product ... products) {
        for (Product product : products) {
            if (cart.getProductsInCart().containsKey(product.getId())) {
                cart.getProductsInCart().remove(product.getId());
                System.out.println(product.getName() + " извлечён из корзину");
            } else {
                System.out.println("Такого товара нет в корзине");
            }
        }
    }
}
