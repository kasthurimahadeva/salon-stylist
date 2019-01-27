package com.kasthuri.authservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class AddDummyUsers {
    @Bean
    CommandLineRunner initSalonDataBase(UserRepository userRepository) {
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            userRepository.save(new AppUser(0, "demo-stylist", encoder.encode("1234"), "stylist"));
            userRepository.save(new AppUser(0, "demo-salon", encoder.encode("1234"), "salon"));
            userRepository.save(new AppUser(0, "admin", encoder.encode("1234"), "admin"));
        };
    }


}