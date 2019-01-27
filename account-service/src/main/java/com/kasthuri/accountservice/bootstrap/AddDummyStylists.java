//package com.kasthuri.accountservice.bootstrap;
//import app.model.StylistModel;
//import app.repositary.StylistRepositary;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@Slf4j
//
//public class AddDummyStylists {
//    @Bean
//    CommandLineRunner initStylistDataBase(StylistRepositary stylistRepositary) {
//        return args -> {
//            log.debug("Preloading " + stylistRepositary.save(new StylistModel("xxx", "xxx",
//                    "xxx", "xxx", "xxx", "xxx", "xxx", 23,
//                    "xxx", "xxx", "xxx","xxx", 3.5)));
//        };
//    }
//}
