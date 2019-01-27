package com.kasthuri.accountservice.repositary;

import com.kasthuri.accountservice.model.SalonModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepositary extends JpaRepository<SalonModel, String> {
}
