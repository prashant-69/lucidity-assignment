package com.lucidity.assignment;

import com.lucidity.assignment.dto.AbstractLocation;
import com.lucidity.assignment.dto.DeliveryRequest;
import com.lucidity.assignment.dto.DeliveryResponse;
import com.lucidity.assignment.dto.Order;
import com.lucidity.assignment.dto.Restaurant;
import com.lucidity.assignment.dto.Customer;
import com.lucidity.assignment.services.DeliveryService;
import com.lucidity.assignment.services.DeliverySystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class DeliveryServiceTest {

    @Mock
    private DeliverySystem deliverySystem;

    @InjectMocks
    private DeliveryService deliveryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calculateDeliveryPath() {
        DeliveryRequest request = new DeliveryRequest(new ArrayList<Order>());

        List<AbstractLocation> bestPath = new ArrayList<>();
        bestPath.add(new Restaurant(10.0, 20.0));
        bestPath.add(new Customer(30.0, 40.0));

        when(deliverySystem.findBestPath()).thenReturn(bestPath);
        when(deliverySystem.calculateTotalTime(anyList())).thenReturn(50.0);

        DeliveryResponse response = deliveryService.calculateDeliveryPath(request);

        assertNotNull(response);
        verify(deliverySystem, times(1)).findBestPath();
        verify(deliverySystem, times(1)).calculateTotalTime(anyList());
    }
}
