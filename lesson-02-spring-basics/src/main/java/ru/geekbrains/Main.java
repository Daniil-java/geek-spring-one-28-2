package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.ProductApp.Config.ProductAppConfig;
import ru.geekbrains.ProductApp.Product;
import ru.geekbrains.ProductApp.Repositories.ProductRepository;
import ru.geekbrains.ProductApp.Services.CartService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ProductAppConfig.class);

        ProductRepository productRepository = new ProductRepository();
        init(productRepository);

        CartService firstCart = context.getBean("cartService", CartService.class);
        CartService secondCart = context.getBean("cartService", CartService.class);
        CartService thirdCart = context.getBean("cartService", CartService.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите команду(add/delete/getList)");

        for (;;) {

            switch (scanner.nextLine()) {
                case ("getList"):
                    System.out.println("Первая корзина: " + firstCart.getProductList());
                    System.out.println("Вторая корзина: " + secondCart.getProductList());
                    System.out.println("Третья корзина: " + thirdCart.getProductList());
                    break;
                case ("add"):
                    System.out.println("Введите id продукта для добавления в первую корзину");
                    firstCart.addProductToCart(productRepository.findById(scanner.nextInt()));

                    System.out.println("Введите id продукта для добавления во вторую корзину");
                    secondCart.addProductToCart(productRepository.findById(scanner.nextLong()));

                    System.out.println("Введите id продукта для добавления в третью корзину");
                    thirdCart.addProductToCart(productRepository.findById(scanner.nextLong()));
                    break;
                case ("remove"):
                    System.out.println("Введите id продукта для извлечения из первой корзину");
                    firstCart.deleteProductFromCart(scanner.nextLong());

                    System.out.println("Введите id продукта для извлечения из второй корзину");
                    secondCart.deleteProductFromCart(scanner.nextLong());

                    System.out.println("Введите id продукта для извлечения из третьей корзину");
                    thirdCart.deleteProductFromCart(scanner.nextLong());
                    break;
                default:
                    System.out.println("Введите команду(add/delete/getList)");
                    break;
            }
        }
    }

    public static void init(ProductRepository productRepository) {
        productRepository.insert(new Product("Banana", 10));
        productRepository.insert(new Product("AnotherBanana", 11));
        productRepository.insert(new Product("Apple", 1000));
        productRepository.insert(new Product("Orange", 5));
        productRepository.insert(new Product("Juice", 20));
        productRepository.insert(new Product("Water", 10));
        productRepository.insert(new Product("Something", 10));
        productRepository.insert(new Product("Spam", 15));
        productRepository.insert(new Product("Eggs", 30));
        productRepository.insert(new Product("Coke", 65));
    }
}
