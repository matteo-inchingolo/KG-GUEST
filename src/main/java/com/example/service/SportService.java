package com.example.service;

import com.example.model.Sport;
import com.example.repository.SportRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SportService {

    @Autowired
    private SportRepository sportRepository;

    public List<Sport> findAll() {
        return sportRepository.findAll();
    }

    public Optional<Sport> findById(String id) {
        return sportRepository.findById(id);
    }

    public Sport createSport(Sport sport) {
        return sportRepository.save(sport);
    }

    public Sport updateSport(String id, Sport sport) {

        Sport existingSport = sportRepository.findById(id).orElse(null);

        if (existingSport == null) {
            throw new EntityNotFoundException("Sport with id " + sport.getId() + " hasn't been found");
        }

        existingSport.setName(sport.getName());
        existingSport.setDescription(sport.getDescription());

        sportRepository.save(existingSport);

        return existingSport;
    }

    public void deleteSport(String id) {

        Sport existingSport = sportRepository.findById(id).orElse(null);
        if (existingSport == null) {
            throw new EntityNotFoundException("Sport with id " + id + " hasn't been found");
        }

        sportRepository.delete(existingSport);
    }

}
