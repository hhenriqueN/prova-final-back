package com.example.demo.service;

import com.example.demo.model.Trip;
import com.example.demo.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private final TripRepository repo;
    public TripService(TripRepository repo) { this.repo = repo; }

    public Trip save(Trip t) { return repo.save(t); }
    public List<Trip> findAll() { return repo.findAll(); }
    public Optional<Trip> findById(Long id) { return repo.findById(id); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
