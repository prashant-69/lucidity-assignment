package com.lucidity.assignment;

import com.lucidity.assignment.controllers.DeliveryController;
import com.lucidity.assignment.dto.*;
import com.lucidity.assignment.services.DeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DeliveryControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DeliveryService deliveryService;

    @InjectMocks
    private DeliveryController deliveryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(deliveryController).build();
    }

    @Test
    void calculatePath() throws Exception {

        List<AbstractLocation> bestPath = new ArrayList<>();
        bestPath.add(new Restaurant(10.0, 20.0));
        bestPath.add(new Customer(30.0, 40.0));

        DeliveryResponse response = new DeliveryResponse(bestPath, 50.0);

        when(deliveryService.calculateDeliveryPath(any(DeliveryRequest.class))).thenReturn(response);

        mockMvc.perform(post("/delivery/calculate-path")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"orders\":[]}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}