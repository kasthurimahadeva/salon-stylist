package com.kasthuri.accountservice.service;

import com.kasthuri.accountservice.model.SalonModel;

import java.util.List;
import java.util.Optional;

public interface SalonService {
    List<SalonModel> findAll();

    SalonModel save(SalonModel salonModel);

    Optional<SalonModel> findById(String salonId);

    void delete(SalonModel salonModel);
}
