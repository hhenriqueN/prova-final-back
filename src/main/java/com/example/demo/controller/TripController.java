package com.example.demo.controller;

import com.example.demo.model.Trip;
import com.example.demo.service.TripService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    private final TripService service;
    public TripController(TripService service) { this.service = service; }

    // create - authenticated users
    @PostMapping
    public ResponseEntity<Trip> create(@RequestBody Trip trip) {
        Trip saved = service.save(trip);
        return ResponseEntity.created(URI.create("/api/trips/" + saved.getId())).body(saved);
    }

    // list - authenticated users
    @GetMapping
    public ResponseEntity<List<Trip>> list() {
        return ResponseEntity.ok(service.findAll());
    }

    // delete - only admin role
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('admin')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
