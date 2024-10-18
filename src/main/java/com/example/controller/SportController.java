package com.example.controller;

import com.example.model.Sport;
import com.example.service.AuthenticationService;
import com.example.service.SportService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/sport")
public class SportController {
    @Autowired
    private SportService sportService;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public List<Sport> findAll(@RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return sportService.findAll();
    }

    @GetMapping("/{id}")
    public Sport findById(@PathVariable String id, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return sportService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lo sport con id " + id + " non è stato trovato"));
    }

    @PostMapping
    public Sport createSport(@RequestBody Sport sport, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return sportService.createSport(sport);
    }

    @PutMapping("/{id}")
    public Sport updateSport(@PathVariable String id, @RequestBody Sport sport, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return sportService.updateSport(id, sport);
    }

    @DeleteMapping("/{id}")
    public void deleteSport(@PathVariable String id, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return;
        }
        sportService.deleteSport(id);
    }
}