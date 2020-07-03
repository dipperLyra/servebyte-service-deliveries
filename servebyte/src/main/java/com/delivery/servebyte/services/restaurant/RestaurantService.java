package com.delivery.servebyte.services.restaurant;

import com.delivery.servebyte.dto.restaurantDTO.RestaurantRequest;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    boolean createRestaurant(RestaurantRequest request);
    void setDeliveryCompany(RestaurantRequest request, Restaurant restaurant);
    Optional<List<Meal>> findRestaurantsAndMeals(String meal);
}
