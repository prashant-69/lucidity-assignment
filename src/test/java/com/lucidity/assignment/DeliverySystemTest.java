package com.lucidity.assignment;

import com.lucidity.assignment.dto.*;
import com.lucidity.assignment.services.DeliverySystem;
import com.lucidity.assignment.utils.DistanceCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeliverySystemTest {

    @Mock
    private StartingPoint startingPoint;

    @Mock
    private DistanceCalculator distanceCalculator;

    @InjectMocks
    private DeliverySystem deliverySystem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addOrder() {
        Order order = new Order();
        Restaurant restaurant = new Restaurant();
        order.setRestaurant(restaurant);

        deliverySystem.addOrder(order);

        assertTrue(deliverySystem.restaurantOrderMap.containsKey(restaurant));
    }

    @Test
    void calculateTotalTime() {
        List<AbstractLocation> path = new ArrayList<>();
        path.add(startingPoint);
        path.add(new Restaurant(1.0, 1.0));
        path.add(new Customer(2.0, 2.0));

        when(distanceCalculator.calculateDistance(any(AbstractLocation.class), any(AbstractLocation.class)))
                .thenReturn(1.0);

        double totalTime = deliverySystem.calculateTotalTime(path);

        assertEquals(0.1, totalTime);
    }

    @Test
    void findBestPath() {
        Order order = new Order(new Customer(2.0, 2.0), new Restaurant(1.0, 1.0), 5.0);
        deliverySystem.addOrder(order);

        List<AbstractLocation> bestPath = deliverySystem.findBestPath();

        assertNotNull(bestPath);
        assertEquals(4, bestPath.size());
        assertEquals(startingPoint, bestPath.get(0));
    }
}
