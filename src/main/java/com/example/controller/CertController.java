package com.example.controller;

import com.example.model.Certificate;
import com.example.service.AuthenticationService;
import com.example.service.CertService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/certificate")
public class CertController {
    @Autowired
    private CertService certificateService;
    
    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping
    public List<Certificate> findAll(
            @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return List.of();
        }
        return certificateService.findAll();
    }

    @GetMapping("/{id}")
    public Certificate findById(@PathVariable String id, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return certificateService.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Lo certificate con id " + id + " non è stato trovato"));
    }

    @PostMapping
    public Certificate createCertificate(@RequestBody Certificate certificate, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return certificateService.createCertificate(certificate);
    }

    @PutMapping("/{id}")
    public Certificate updateCertificate(@PathVariable String id, @RequestBody Certificate certificate, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return null;
        }
        return certificateService.updateCertificate(id, certificate);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable String id, @RequestHeader("Authorization") String headers) {
        if(!authenticationService.isAuthorized(headers)){
            return;
        }
        certificateService.deleteCertificate(id);
    }
}