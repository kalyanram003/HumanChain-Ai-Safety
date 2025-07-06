package com.Incident_Api.Incident_API.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Incident_Api.Incident_API.entity.Incident;
import com.Incident_Api.Incident_API.service.IncidentService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/incidents")
public class IncidentController {

    private final IncidentService incidentService;

    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @GetMapping
    public ResponseEntity<List<Incident>> getAllIncidents() {
        return ResponseEntity.ok(incidentService.getAllIncidents());
    }

    @PostMapping
    public ResponseEntity<?> createIncident(@Valid @RequestBody Incident incident) {
        if (!isValidSeverity(incident.getSeverity())) {
            return ResponseEntity.badRequest().body("Severity must be Low, Medium, or High");
        }
        Incident created = incidentService.createIncident(incident);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getIncidentById(@PathVariable Long id) {
        return incidentService.getIncidentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncident(@PathVariable Long id) {
        if (!incidentService.getIncidentById(id).isPresent()) {
            return ResponseEntity.status(404).body("Incident not found");
        }
        incidentService.deleteIncident(id);
        return ResponseEntity.ok("Incident deleted successfully");
    }

    private boolean isValidSeverity(String severity) {
        return "Low".equalsIgnoreCase(severity) ||
               "Medium".equalsIgnoreCase(severity) ||
               "High".equalsIgnoreCase(severity);
    }
}

