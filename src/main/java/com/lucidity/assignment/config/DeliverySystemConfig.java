package com.lucidity.assignment.config;

import com.lucidity.assignment.dto.Order;
import com.lucidity.assignment.dto.Restaurant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DeliverySystemConfig {

    @Bean
    public Map<Restaurant, Order> restaurantOrderMap() {
        return new HashMap<>();
    }
}
