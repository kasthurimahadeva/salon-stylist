package com.kasthuri.accountservice.service.impl;

import com.kasthuri.accountservice.model.StylistModel;
import com.kasthuri.accountservice.repositary.StylistRepositary;
import com.kasthuri.accountservice.service.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service("StylistServiceImpl")
public class StylistServiceImpl implements StylistService {
    private StylistRepositary stylistRepositary;

    @Override
    public List<StylistModel> findAll() {
        return stylistRepositary.findAll();
    }

    @Override
    public StylistModel save(@RequestBody StylistModel stylistModel) {
        return stylistRepositary.save(stylistModel);
    }

    @Override
    public Optional<StylistModel> findById(String stylistId) {
        return stylistRepositary.findById(stylistId);
    }

    @Override
    public void delete(StylistModel stylistModel) {
        stylistRepositary.delete(stylistModel);
    }

    @Override
    public Optional<Iterable<StylistModel>> findBySkill(String skill) {
        return this.stylistRepositary.findBySkill(skill);
    }

    @Override
    public Optional<Iterable<StylistModel>> findByEmail(String email) {
        return this.stylistRepositary.findByEmail(email);
    }


    @Autowired
    public void setStylistRepositary(StylistRepositary stylistRepositary) {
        this.stylistRepositary = stylistRepositary;
    }
}
