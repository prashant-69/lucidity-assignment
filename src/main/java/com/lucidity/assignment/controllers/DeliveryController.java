package com.lucidity.assignment.controllers;

import com.lucidity.assignment.dto.DeliveryRequest;
import com.lucidity.assignment.dto.DeliveryResponse;
import com.lucidity.assignment.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @Autowired
    private final DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/calculate-path")
    public DeliveryResponse calculatePath(@RequestBody DeliveryRequest request) {
        return deliveryService.calculateDeliveryPath(request);
    }
}


