package com.delivery.servebyte.services.restaurant;

import com.delivery.servebyte.dto.restaurantDTO.RestaurantRequest;

public interface RestaurantService {
    boolean createRestaurant(RestaurantRequest request);
}
