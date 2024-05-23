package com.lucidity.assignment;

import com.lucidity.assignment.dto.AbstractLocation;
import com.lucidity.assignment.dto.Customer;
import com.lucidity.assignment.dto.Restaurant;
import com.lucidity.assignment.utils.DistanceCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    private final DistanceCalculator distanceCalculator = new DistanceCalculator();

    @Test
    void calculateDistance() {
        AbstractLocation loc1 = new Restaurant(0.0, 0.0);
        AbstractLocation loc2 = new Customer(1.0, 1.0);

        double distance = distanceCalculator.calculateDistance(loc1, loc2);

        assertEquals(157.24938127194397, distance);
    }
}
