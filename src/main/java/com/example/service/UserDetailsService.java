package com.example.service;

import com.example.model.UserDetails;
import com.example.repository.UserDetailsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    public List<UserDetails> findAll() {
        return userDetailsRepository.findAll();
    };

    public Optional<UserDetails> findById(String id) {
        return userDetailsRepository.findById(id);
    }

    public UserDetails createUser(UserDetails userDetails) {
        return userDetailsRepository.save(userDetails);
    }

    public List<UserDetails> createUsers(List<UserDetails> userDetails) {
        return userDetailsRepository.saveAll(userDetails);
    }

    public UserDetails updateUser(String id, UserDetails userDetails) {

        UserDetails existingUserDetails = userDetailsRepository.findById(id).orElse(null);

        if (existingUserDetails == null) {
            throw new EntityNotFoundException("User with id " + userDetails.getId() + " hasn't been found");
        }

        existingUserDetails.setName(userDetails.getName());
        existingUserDetails.setFiscalCode(userDetails.getFiscalCode());
        existingUserDetails.setBirthDate(userDetails.getBirthDate());
        existingUserDetails.setCity(userDetails.getCity());
        existingUserDetails.setAddress(userDetails.getAddress());
        existingUserDetails.setSportId(userDetails.getSportId());
        existingUserDetails.setSubscriptionId(userDetails.getSubscriptionId());
        existingUserDetails.setStartDate(userDetails.getStartDate());
        existingUserDetails.setEndDate(userDetails.getEndDate());
        existingUserDetails.setRemovalDate(userDetails.getRemovalDate());
        existingUserDetails.setSex(userDetails.getSex());

        userDetailsRepository.save(existingUserDetails);

        return existingUserDetails;
    }

    public void deleteUser(String id) {

        UserDetails existingUserDetails = userDetailsRepository.findById(id).orElse(null);

        /*
            False check, we'll never assume that a user could be non-existent
         */
        if (existingUserDetails == null) {
            throw new EntityNotFoundException("User with id " + id + " hasn't been found");
        }

        userDetailsRepository.delete(existingUserDetails);
    }

}
