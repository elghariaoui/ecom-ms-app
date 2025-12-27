package net.soufiane.customerservice;

import net.soufiane.customerservice.Repository.CustomerRepository;
import net.soufiane.customerservice.config.CustomerConfigParams;
import net.soufiane.customerservice.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("Soufiane").email("soufiane@gmail.com").build());
            customerRepository.save(Customer.builder()
                    .name("Imad").email("imad@gmail.com").build());
            customerRepository.save(Customer.builder()
                    .name("Diego").email("diego@gmail.com").build());

        };
    }


}
