## **_Lucidity: Machine coding assignment_**

## Approach

 ```

This approach used here is based on: 
    That each restaurant is visited before its associated customer, and it calculates the total time considering both travel time and preparation time at restaurants.

    1. Input:
        - Locations: A (starting point), multiple restaurants, and their associated customers.
        - Prepration times: Time required to prepare food at each restaurant.

    2. Calculate Distances:
        - Determine the distance between each pair of locations using a distance calculation based on Haversine formula for geographic coordinates.

    3. Path Generation:
        - Begin at the starting point.
        - Visit each restaurant and its associated customer one by one.
        - Ensure that each restaurant is visited before its associated customer.

    4. Total Time Calculation:
        - For each step in the path, calculate the time taken to travel from the current location to the next location.
        - Add the preparation time for each restaurant to the total time.

    5. Output:
        - Returning the sequence of locations visited, starting from the starting point.
        - Returning the total time taken for the entire route, including travel time and preparation time at restaurants.
 ```


## Technologies Used

- Java
- Spring Boot

## Project Components

 ```

### DTO (Data Transfer Object)

- `AbstractLocation`: Abstract class representing a location with latitude and longitude.
- `Customer`: Represents a customer location.
- `Restaurant`: Represents a restaurant location.
- `Order`: Represents an order with a customer, restaurant, and preparation time.
- `DeliveryRequest`: Represents a delivery request containing a list of orders.
- `DeliveryResponse`: Represents a delivery response containing the best path and total time.
- `StartingPoint`: Concrete implementation of `AbstractLocation` for the starting point of the delivery.

### Service

- `DeliveryService`: Handles the calculation of the best delivery path and total time.
- `DeliverySystem`: Core logic for adding orders, calculating total time, and finding the best path.

### Controller

- `DeliveryController`: Exposes API endpoints for the delivery system.

### Utils

- `DistanceCalculator`: Utility class for calculating the distance between two locations using the Haversine formula.

## How It Works

1. Path Calculation: The `DeliveryService` class calculates the best delivery path and total time using the `DeliverySystem` class.
2. Distance Calculation: The `DistanceCalculator` class provides the method to calculate the distance between two locations.
3. API Endpoint: The `DeliveryController` exposes a POST endpoint (`/delivery/calculate-path`) to calculate the best delivery path given a `DeliveryRequest`.

### API Usage

#### Calculate Delivery Path

- Endpoint: `/delivery/calculate-path`
- Method: POST
- Request Body:

    {
      "orders": [
        {
          "customer": {
            "latitude": 40.712776,
            "longitude": -74.005974
          },
          "restaurant": {
            "latitude": 40.730610,
            "longitude": -73.935242
          },
          "preparationTime": 15.0
        },
        {
          "customer": {
            "latitude": 40.748817,
            "longitude": -73.985428
          },
          "restaurant": {
            "latitude": 40.729513,
            "longitude": -73.998508
          },
          "preparationTime": 10.0
        }
      ]
    }

- Response Body:
    {
      "bestPath": [
        {
          "latitude": 40.7128,
          "longitude": -74.0060
        },
        {
          "latitude": 40.730610,
          "longitude": -73.935242
        },
        {
          "latitude": 40.712776,
          "longitude": -74.005974
        },
        {
          "latitude": 40.729513,
          "longitude": -73.998508
        },
        {
          "latitude": 40.748817,
          "longitude": -73.985428
        },
        {
          "latitude": 40.7128,
          "longitude": -74.0060
        }
      ],
      "totalTime": 40.0
    }

 ```