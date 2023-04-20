package com.ecommerce.mangashop.testConfiguration;

import com.ecommerce.mangashop.domains.User;
import com.ecommerce.mangashop.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@TestConfiguration
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