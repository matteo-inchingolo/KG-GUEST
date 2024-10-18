package com.example.repository;

import com.example.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SportRepository extends JpaRepository<Sport, String> {

    @Override
    List<Sport> findAll();

    @Override
    Optional<Sport> findById(String id);

}