package com.example.controller;

import com.example.model.Subscription;
import com.example.service.AuthenticationService;
import com.example.service.SubService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/subscription")
public class SubController {
    @Autowired
    private SubService subscriptionService;
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public List<Subscription> findAll(@RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return subscriptionService.findAll();
    }

    @GetMapping("/{id}")
    public Subscription findById(@PathVariable String id, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return subscriptionService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lo subscription con id " + id + " non è stato trovato"));
    }

    @PostMapping
    public Subscription createSubscription(@RequestBody Subscription subscription, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return subscriptionService.createSubscription(subscription);
    }

    @PutMapping("/{id}")
    public Subscription updateSubscription(@PathVariable String id, @RequestBody Subscription subscription, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return subscriptionService.updateSubscription(id, subscription);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable String id, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return;
        }
        subscriptionService.deleteSubscription(id);
    }
}