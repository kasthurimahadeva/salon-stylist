package com.kasthuri.bookingservice;

import com.kasthuri.bookingservice.model.BookingModel;
import com.kasthuri.bookingservice.repository.BookingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Configuration
public class AddDummyBooking {

    @Bean
    CommandLineRunner initSalonDataBase(BookingRepository bookingRepository) {
        return args -> {
            bookingRepository.save(new BookingModel("booking1", "salon1", "stylist1", new Date(), "approved"));
            bookingRepository.save(new BookingModel("booking2", "salon2", "stylist1", new Date(), "pending"));
        };
    }
}
