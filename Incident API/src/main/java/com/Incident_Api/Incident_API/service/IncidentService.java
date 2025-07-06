package com.Incident_Api.Incident_API.service;


import java.util.List;
import java.util.Optional;

import com.Incident_Api.Incident_API.entity.Incident;

public interface IncidentService {
    List<Incident> getAllIncidents();
    Incident createIncident(Incident incident);
    Optional<Incident> getIncidentById(Long id);
    void deleteIncident(Long id);
}

