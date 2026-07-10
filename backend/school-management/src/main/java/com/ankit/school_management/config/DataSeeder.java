package com.ankit.school_management.config;

import com.ankit.school_management.entity.Role;
import com.ankit.school_management.entity.User;
import com.ankit.school_management.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner seedDevelopmentUsers(UserRepository userRepository) {
        return args -> {
            seedUser(userRepository, "teacher", "teacher123", Role.TEACHER);
            seedUser(userRepository, "student", "student123", Role.STUDENT);
            seedUser(userRepository, "parent", "parent123", Role.PARENT);
        };
    }

    private void seedUser(
            UserRepository userRepository,
            String username,
            String password,
            Role role) {

        if (userRepository.findByUsername(username).isEmpty()) {
            userRepository.save(new User(username, password, role));
        }
    }
}