package com.kasthuri.accountservice.repositary;

import com.kasthuri.accountservice.model.StylistModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StylistRepositary extends JpaRepository<StylistModel, String> {
    Optional<Iterable<StylistModel>> findBySkill(String skill);
}
