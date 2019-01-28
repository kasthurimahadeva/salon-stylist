package com.kasthuri.accountservice.service.impl;

import com.kasthuri.accountservice.model.SalonModel;
import com.kasthuri.accountservice.repositary.SalonRepositary;
import com.kasthuri.accountservice.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service("salonServiceImpl")
public class SalonServiceImpl implements SalonService {

    private SalonRepositary salonRepositary;

    @Override
    public List<SalonModel> findAll() {
        return salonRepositary.findAll();
    }

    @Override
    public SalonModel save(@RequestBody SalonModel salonModel) {
        return salonRepositary.save(salonModel);
    }

    @Override
    public Optional<SalonModel> findById(String salonId) {
        return salonRepositary.findById(salonId);
    }

    @Override
    public void delete(SalonModel salonModel) {
        salonRepositary.delete(salonModel);
    }

    @Override
    public Optional<Iterable<SalonModel>> findByEmail(String email) {
        return this.salonRepositary.findByEmail(email);
    }

    @Autowired
    public void setSalonRepositary(SalonRepositary salonRepositary) {
        this.salonRepositary = salonRepositary;
    }
}