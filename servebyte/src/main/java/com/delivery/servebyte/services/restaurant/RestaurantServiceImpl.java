package com.delivery.servebyte.services.restaurant;

import com.delivery.servebyte.dto.mealDTO.MealResponse;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.dto.restaurantDTO.RestaurantRequest;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import com.delivery.servebyte.persistence.repositories.MealRepository;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    DeliveryCompanyRepository deliveryCompanyRepository;
    @Autowired
    MealRepository mealRepository;

    @Override
    public boolean createRestaurant(RestaurantRequest request) {
        Restaurant restaurant = new Restaurant();

        restaurant.setCreated_on(new Timestamp(new Date().getTime()));
        restaurant.setEmail(request.getEmail());
        restaurant.setLogo(request.getLogo());
        restaurant.setName(request.getRestaurantName());
        restaurant.setPhoneNumber(request.getPhoneNumber());
        restaurant.setPassword(request.getPassword());
        restaurant.setCity(request.getCity());
        restaurant.setMeals(request.getMeals());
        this.setDeliveryCompany(request, restaurant);
        restaurantRepository.save(restaurant);
        return true;
    }

    @Override
    public Collection<MealResponse> findRestaurantsAndMeals(String meal) {
        return mealRepository.findByNameContaining(meal);
    }

    @Override
    public void setDeliveryCompany(RestaurantRequest request, Restaurant restaurant) {

        for (String deliveryCompanyName:request.getDeliveryCompany()) {
             Set<DeliveryCompany> deliveryCompany =
                    deliveryCompanyRepository.findByName(deliveryCompanyName);

             restaurant.setDeliveryCompanies(deliveryCompany);
        }
    }
}
