package net.soufiane.inventoryservice;

import net.soufiane.inventoryservice.Reprository.ProductRepository;
import net.soufiane.inventoryservice.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer").price(3400).quantity(10).build());
            productRepository.save(Product.builder()
                    .name("Smart Phone").price(400).quantity(20).build());
            productRepository.save(Product.builder()
                    .name("Printer").price(1000).quantity(10).build());
            productRepository.save(Product.builder()
                    .name("Laptop").price(2000).quantity(30).build());

        };
    }
}
