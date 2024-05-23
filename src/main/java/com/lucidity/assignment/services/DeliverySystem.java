package com.lucidity.assignment.services;

import com.lucidity.assignment.constants.Constants;
import com.lucidity.assignment.dto.AbstractLocation;
import com.lucidity.assignment.dto.Order;
import com.lucidity.assignment.dto.Restaurant;
import com.lucidity.assignment.dto.StartingPoint;
import com.lucidity.assignment.utils.DistanceCalculator;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

@Service
public class DeliverySystem {

    @Autowired
    private final AbstractLocation startingPoint;

    @Autowired
    public final Map<Restaurant, Order> restaurantOrderMap;

    @Autowired
    private final DistanceCalculator distanceCalculator;

    public DeliverySystem(StartingPoint startingPoint, DistanceCalculator distanceCalculator) {
        this.startingPoint = startingPoint;
        this.restaurantOrderMap = new HashMap<>();
        this.distanceCalculator = distanceCalculator;
    }

    public void addOrder(Order order) {
        restaurantOrderMap.put(order.getRestaurant(), order);
    }

    public double calculateTotalTime(@NotNull List<AbstractLocation> path) {
        double totalTime = 0.0;
        AbstractLocation currentLocation = path.get(0);
        for (int i = 1; i < path.size(); i++) {
            if (currentLocation instanceof Restaurant) {
                Order order = restaurantOrderMap.get(currentLocation);
                if (order != null) {
                    totalTime += order.getPreparationTime();
                }
            }
            totalTime += distanceCalculator.calculateDistance(currentLocation, path.get(i)) / Constants.RIDER_SPEED;
            currentLocation = path.get(i);
        }
        return totalTime;
    }

    public List<AbstractLocation> findBestPath() {
        int numLocations = restaurantOrderMap.size() * 2 + 1;
        List<AbstractLocation> bestPath = new ArrayList<>(numLocations);
        bestPath.add(startingPoint);
        for (Map.Entry<Restaurant, Order> entry : restaurantOrderMap.entrySet()) {
            Restaurant restaurant = entry.getKey();
            Order order = entry.getValue();
            bestPath.add(restaurant);
            bestPath.add(order.getCustomer());
        }
        bestPath.add(startingPoint);
        return bestPath;
    }
}
