package com.example.service;

import com.example.model.Subscription;
import com.example.repository.CertRepository;
import com.example.repository.SubRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubService {

    @Autowired
    private SubRepository subscriptionRepository;

    public List<Subscription> findAll() {
        return subscriptionRepository.findAll();
    }

    public Optional<Subscription> findById(String id) {
        return subscriptionRepository.findById(id);
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public Subscription updateSubscription(String id, Subscription subscription) {

        Subscription existingSubscription = subscriptionRepository.findById(id).orElse(null);

        if (existingSubscription == null) {
            throw new EntityNotFoundException("Subscription with id " + subscription.getId()+ " hasn't been found");
        }

        existingSubscription.setCost(subscription.getCost());
        existingSubscription.setDescription(subscription.getDescription());
        existingSubscription.setName(subscription.getName());

        subscriptionRepository.save(existingSubscription);

        return existingSubscription;
    }

    public void deleteSubscription(String id) {

        Subscription existingSubscription = subscriptionRepository.findById(id).orElse(null);
        if (existingSubscription == null) {
            throw new EntityNotFoundException("Subscription with id " + id + " hasn't been found");
        }

        subscriptionRepository.delete(existingSubscription);
    }

}
