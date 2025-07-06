package com.Incident_Api.Incident_API.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Incident_Api.Incident_API.entity.Incident;

public interface IncidentRepository extends JpaRepository<Incident, Long> {
    
}

