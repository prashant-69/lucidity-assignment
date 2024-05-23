package com.lucidity.assignment.controllers;

import com.lucidity.assignment.dto.SimpleStatusResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

  @GetMapping("/health")
  public ResponseEntity<SimpleStatusResponse> getHealthCheck() {
    return ResponseEntity.ok(new SimpleStatusResponse("OK"));
  }
}