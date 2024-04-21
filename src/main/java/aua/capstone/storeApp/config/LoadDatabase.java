package aua.capstone.storeApp.config;
import aua.capstone.storeApp.model.entity.Customer;
import aua.capstone.storeApp.model.entity.Product;
import aua.capstone.storeApp.repository.CustomerRepository;
import aua.capstone.storeApp.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    private final PasswordEncoder passwordEncoder;

    public LoadDatabase() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner initCustomers(CustomerRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Customer("admin@gmail.com", passwordEncoder.encode("adminpass"))));
            log.info("Preloading " + repository.save(new Customer("user@yahoo.com", passwordEncoder.encode("qwerty1234"))));
        };
    }

    @Bean
    CommandLineRunner initProducts(ProductRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Product(2364, "Nail gun", 8, 23.76)));
            log.info("Preloading " + repository.save(new Product(8900, "Charger", 2, 108.33)));
        };

        // ... initProducts remains the same ...
    }
}


