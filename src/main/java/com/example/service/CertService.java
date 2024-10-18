package com.example.service;

import com.example.model.Certificate;
import com.example.repository.CertRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertService {

    @Autowired
    private CertRepository certificateRepository;

    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    public Optional<Certificate> findById(String id) {
        return certificateRepository.findById(id);
    }

    public Certificate createCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public Certificate updateCertificate(String id, Certificate certificate) {

        Certificate existingCertificate = certificateRepository.findById(id).orElse(null);

        if (existingCertificate == null) {
            throw new EntityNotFoundException("Certificate with id " + certificate.getUserId()+ " hasn't been found");
        }

        existingCertificate.setResult(certificate.getResult());
        existingCertificate.setStartDate(certificate.getStartDate());
        existingCertificate.setEndDate(certificate.getEndDate());

        certificateRepository.save(existingCertificate);

        return existingCertificate;
    }

    public void deleteCertificate(String id) {

        Certificate existingCertificate = certificateRepository.findById(id).orElse(null);
        if (existingCertificate == null) {
            throw new EntityNotFoundException("Certificate with id " + id + " hasn't been found");
        }

        certificateRepository.delete(existingCertificate);
    }

}
