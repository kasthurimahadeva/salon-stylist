package com.kasthuri.authservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {

    Optional<Iterable<AppUser>> findByUsername(String username);
}
