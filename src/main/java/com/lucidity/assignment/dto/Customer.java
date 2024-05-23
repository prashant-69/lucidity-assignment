package com.lucidity.assignment.dto;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Customer extends AbstractLocation {
    public Customer(double latitude, double longitude) {
        super(latitude, longitude);
    }
}

