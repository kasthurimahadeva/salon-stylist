package com.kasthuri.accountservice.repositary;

import com.kasthuri.accountservice.model.StylistModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StylistRepositary extends JpaRepository<StylistModel, String> {
}
