package com.Incident_Api.Incident_API.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Incident_Api.Incident_API.entity.Incident;
import com.Incident_Api.Incident_API.repository.IncidentRepository;

@Service
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository incidentRepository;

    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public List<Incident> getAllIncidents() {
        return incidentRepository.findAll();
    }

    @Override
    public Incident createIncident(Incident incident) {
        incident.setReportedAt(LocalDateTime.now());
        return incidentRepository.save(incident);
    }

    @Override
    public Optional<Incident> getIncidentById(Long id) {
        return incidentRepository.findById(id);
    }

    @Override
    public void deleteIncident(Long id) {
        incidentRepository.deleteById(id);
    }
}

