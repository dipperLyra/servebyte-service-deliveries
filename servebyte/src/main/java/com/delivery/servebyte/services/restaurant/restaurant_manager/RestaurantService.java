package com.delivery.servebyte.services.restaurant.restaurant_manager;

import com.delivery.servebyte.dto.mealDTO.MealRequest;
import com.delivery.servebyte.dto.mealDTO.MealRestaurantResponse;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.projections.MealResponse;
import com.delivery.servebyte.dto.restaurantDTO.RestaurantRequest;
import com.delivery.servebyte.dto.restaurantDTO.RestaurantResponse;

import java.util.Collection;
import java.util.List;

public interface RestaurantService {
    boolean createRestaurant(RestaurantRequest request);
    boolean createMeal(MealRequest request);
    RestaurantResponse getRestaurant(Long id);
    List<RestaurantResponse> listRestaurants();
    Collection<MealRestaurantResponse> searchMealInRestaurants(String meal);
    boolean updateRestaurant(Long restaurantId, RestaurantRequest request);
    void deleteRestaurant(Long restaurantId);
}
