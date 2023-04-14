package com.ecommerce.mangashop.configuration;

import com.ecommerce.mangashop.domains.User;
import com.ecommerce.mangashop.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User user = new User("user@email.com","password");
            userRepository.save(user);
        };
    }
}
