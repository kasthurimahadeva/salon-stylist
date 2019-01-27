package com.kasthuri.accountservice.service;

import com.kasthuri.accountservice.model.StylistModel;

import java.util.List;
import java.util.Optional;

public interface StylistService {
    List<StylistModel> findAll();

    StylistModel save(StylistModel stylistModel);

    Optional<StylistModel> findById(String stylistId);

    void delete(StylistModel stylistModel);
    Optional<Iterable<StylistModel>> findBySkill(String skill);
}
