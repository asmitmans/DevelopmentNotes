package com.example.SpringSecurityJWTDemo.service;

import com.example.SpringSecurityJWTDemo.repository.RoleRepository;
import com.example.SpringSecurityJWTDemo.repository.UserRepository;
import com.example.SpringSecurityJWTDemo.model.Role;
import com.example.SpringSecurityJWTDemo.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadData(
            UserRepository userRepository,
            RoleRepository roleRepository
    ) {
        return args -> {
            if (roleRepository.count() == 0) {
                Role userRole = new Role("ROLE_USER");
                Role adminRole = new Role("ROLE_ADMIN");
                roleRepository.save(userRole);
                roleRepository.save(adminRole);
            }

            if (userRepository.count() == 0) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

                User user = new User();
                user.setUsername("user");
                user.setPassword(encoder.encode("1234"));
                user.setRoles(Set.of(roleRepository.findByName("ROLE_USER")
                                                   .get()));

                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin1234"));
                admin.setRoles(Set.of(roleRepository.findByName("ROLE_ADMIN")
                                                    .get()));
                userRepository.save(user);
                userRepository.save(admin);
            }
        };
    }
}
