package com.lucidity.assignment.utils;


import com.lucidity.assignment.constants.Constants;
import com.lucidity.assignment.dto.AbstractLocation;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class DistanceCalculator {
    public double calculateDistance(@NotNull AbstractLocation loc1, @NotNull AbstractLocation loc2) {
        double lat1 = loc1.getLatitude();
        double lon1 = loc1.getLongitude();
        double lat2 = loc2.getLatitude();
        double lon2 = loc2.getLongitude();

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return Constants.EARTH_RADIUS * c;
    }
}

