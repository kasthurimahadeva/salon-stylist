package com.kasthuri.accountservice.controller;

import com.kasthuri.accountservice.model.StylistModel;
import com.kasthuri.accountservice.service.StylistService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/stylists")
public class StylistController {
    private StylistService stylistService;

    @GetMapping("/")
    public List<StylistModel> getStylistDetails() {
        return stylistService.findAll();
    }

    @PostMapping("/create")
    public StylistModel save(@RequestBody StylistModel stylistModel) {
        return stylistService.save(stylistModel);
    }

    @GetMapping("/find/{email}")
    public StylistModel getStylistByEmail(@PathVariable String email) {
        Optional<Iterable<StylistModel>> result = stylistService.findByEmail(email);
        return result.map(salonModels -> salonModels.iterator().next()).orElse(null);
    }

    @GetMapping("/{stylistId}")
    public StylistModel get(@PathVariable String stylistId) {
        Optional<StylistModel> stylist = stylistService.findById(stylistId);
        if (stylist.isPresent()) {
            return stylist.get();
        }

        return null;
    }

    @PutMapping("/{stylistId}")
    public StylistModel update(@PathVariable String stylistId, @RequestBody StylistModel stylistModel) {
        Optional<StylistModel> existingStylistModel = stylistService.findById(stylistId);
        if (existingStylistModel.isPresent()) {
            BeanUtils.copyProperties(stylistModel, existingStylistModel);
            return stylistService.save(existingStylistModel.get());
        }
        return null;
    }

    @DeleteMapping("/{stylistId}")
    public void delete(@PathVariable String stylistId) {
        Optional<StylistModel> existingStylistModel = stylistService.findById(stylistId);
        if (existingStylistModel.isPresent()) {
            stylistService.delete(existingStylistModel.get());
        }
    }

    @GetMapping("/search/{skill}")
    public Iterable<StylistModel> search(@PathVariable String skill) {
        Optional<Iterable<StylistModel>> stylists = this.stylistService.findBySkill(skill);
        if (stylists.isPresent()) {
            return stylists.get();
        }
        return null;
    }

    @Autowired
    public void setSalonService(StylistService stylistService) {
        this.stylistService = stylistService;
    }
}
