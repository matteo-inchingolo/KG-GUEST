package com.example.repository;

import com.example.model.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Auth, String> {

    @Override
    List<Auth> findAll();

    @Override
    Optional<Auth> findById(String id);

}