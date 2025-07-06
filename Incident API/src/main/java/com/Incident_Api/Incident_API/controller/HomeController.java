package com.Incident_Api.Incident_API.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
            "message", "Backend of Incident-log-api",
            "status", "success",
            "endpoints", Map.of(
                "create_incident", "/incidents (POST)",
                "get_incident", "/incidents/id",
                "delete_incident", "/incidents/id (DELETE)",
                "all incidents", "/incidents"
            )
        );
    }
}
