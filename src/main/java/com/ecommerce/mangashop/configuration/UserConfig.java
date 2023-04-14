package com.ecommerce.mangashop.configuration;

import com.ecommerce.mangashop.domains.User;
import com.ecommerce.mangashop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class UserConfig {

    private final PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User user = new User("user@email.com",passwordEncoder.encode("password"));
            userRepository.save(user);
        };
    }
}
