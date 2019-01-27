//package com.kasthuri.accountservice.bootstrap;
//
//import app.model.SalonModel;
//import app.repositary.SalonRepositary;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//@Slf4j
//
//public class AddDummySalons {
//    @Bean
//    CommandLineRunner initSalonDataBase(SalonRepositary salonRepositary) {
//        return args -> {
//            log.debug("Preloading " + salonRepositary.save(new SalonModel("xxx","xxx", "xxx", "xxx", "xxx", "xxx", "xxx", 400, "xxx", "xxx","xxx")));
//
//        };
//    }
//
//
//}