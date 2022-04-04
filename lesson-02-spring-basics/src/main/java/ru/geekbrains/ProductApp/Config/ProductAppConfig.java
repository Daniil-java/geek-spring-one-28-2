package ru.geekbrains.ProductApp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.geekbrains.ProductApp.Cart;
import ru.geekbrains.ProductApp.Product;
import ru.geekbrains.ProductApp.Repositories.ProductRepository;
import ru.geekbrains.ProductApp.Services.CartService;

@Configuration
@ComponentScan("ru.geekbrains")
public class ProductAppConfig {
    @Bean
    public ProductRepository productRepository() {
        return new ProductRepository();
    }

    @Bean
    @Scope("prototype")
    public CartService cartService() {
        return new CartService();
    }
}
