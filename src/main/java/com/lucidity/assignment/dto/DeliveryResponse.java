package com.lucidity.assignment.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DeliveryResponse {
    private List<AbstractLocation> bestPath;
    private double totalTime;
}

