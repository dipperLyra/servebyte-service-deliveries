package com.delivery.servebyte.services.restaurant;

import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    RestaurantRepository restaurantRepository;

    public Restaurant newRestaurant(Restaurant restaurant)
    {
        return  restaurantRepository.save(restaurant);
    }
}
//Meals: photo, price, time to prepare the meal, description