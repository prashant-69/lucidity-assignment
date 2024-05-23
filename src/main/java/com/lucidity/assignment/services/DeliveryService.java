package com.lucidity.assignment.services;

import com.lucidity.assignment.dto.AbstractLocation;
import com.lucidity.assignment.dto.DeliveryRequest;
import com.lucidity.assignment.dto.DeliveryResponse;
import com.lucidity.assignment.dto.Order;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    private final DeliverySystem deliverySystem;

    @Autowired
    public DeliveryService(DeliverySystem deliverySystem) {
        this.deliverySystem = deliverySystem;
    }

    public DeliveryResponse calculateDeliveryPath(@NotNull DeliveryRequest request) {
        for (Order order : request.getOrders()) {
            deliverySystem.addOrder(order);
        }
        List<AbstractLocation> bestPath = deliverySystem.findBestPath();
        double totalTime = deliverySystem.calculateTotalTime(bestPath);
        return new DeliveryResponse(bestPath, totalTime);
    }
}

