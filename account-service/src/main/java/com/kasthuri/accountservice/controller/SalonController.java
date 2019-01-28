package com.kasthuri.accountservice.controller;

import com.kasthuri.accountservice.model.SalonModel;
import com.kasthuri.accountservice.service.SalonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/salons")
public class SalonController {

    private SalonService salonService;

    @GetMapping("/")
    public List<SalonModel> getSalonDetails() {
        return salonService.findAll();
    }

    @PostMapping("/create")
    public SalonModel create(@RequestBody SalonModel salonModel) {
        return salonService.save(salonModel);
    }

    @GetMapping("/find/{email}")
    public SalonModel getSalonByEmail(@PathVariable String email) {
        Optional<Iterable<SalonModel>> result = salonService.findByEmail(email);
        return result.map(salonModels -> salonModels.iterator().next()).orElse(null);
    }

    @GetMapping("/{salonId}")
    public SalonModel get(@PathVariable String salonId) {
        Optional<SalonModel> salonModel = salonService.findById(salonId);
        if (salonModel.isPresent()) {
            return salonModel.get();
        }
        return null;
    }

    @PutMapping("/{salonId")
    public SalonModel update(@PathVariable String salonId, @RequestBody SalonModel salonModel) {
        Optional<SalonModel> existingSalonModel = salonService.findById(salonId);
        if (existingSalonModel.isPresent()) {
            BeanUtils.copyProperties(salonModel, existingSalonModel);
            return salonService.save(existingSalonModel.get());
        }
        return null;
    }

    @DeleteMapping("/{salonId}")
    public void delete(String salonId) {
        Optional<SalonModel> existingSalonModel = salonService.findById(salonId);
        if (existingSalonModel.isPresent()) {
            salonService.delete(existingSalonModel.get());
        }
    }

    @Autowired
    public void setSalonService(SalonService salonService) {
        this.salonService = salonService;
    }
}

