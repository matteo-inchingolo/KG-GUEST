package com.example.repository;

import com.example.model.Certificate;
import com.example.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CertRepository extends JpaRepository<Certificate, String> {

    List<Certificate> findAll();

    Optional<Certificate> findById(String id);

}