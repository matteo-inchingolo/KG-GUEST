package com.example.repository;

import com.example.model.Sport;
import com.example.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubRepository extends JpaRepository<Subscription, String> {

    List<Subscription> findAll();

    Optional<Subscription> findById(String id);

}