package com.kasthuri.accountservice.repositary;

import com.kasthuri.accountservice.model.SalonModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalonRepositary extends JpaRepository<SalonModel, String> {
    Optional<Iterable<SalonModel>> findByEmail(String email);
}
