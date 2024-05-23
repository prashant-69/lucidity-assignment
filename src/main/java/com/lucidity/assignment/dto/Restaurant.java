package com.lucidity.assignment.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Restaurant extends AbstractLocation {
    public Restaurant(double latitude, double longitude) {
        super(latitude, longitude);
    }
}

