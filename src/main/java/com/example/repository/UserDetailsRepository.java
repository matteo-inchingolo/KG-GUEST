package com.example.repository;

import com.example.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, String> {

    List<UserDetails> findAll();

    Optional<UserDetails> findById(String id);

}
