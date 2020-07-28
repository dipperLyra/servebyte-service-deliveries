package com.delivery.servebyte.services.restaurant.restaurant_manager.impl;

import com.delivery.servebyte.PasswordEncoderUtil;
import com.delivery.servebyte.dto.mealDTO.MealRequest;
import com.delivery.servebyte.dto.mealDTO.MealRestaurantResponse;
import com.delivery.servebyte.projections.MealResponse;
import com.delivery.servebyte.dto.restaurantDTO.RestaurantRequest;
import com.delivery.servebyte.dto.restaurantDTO.RestaurantResponse;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import com.delivery.servebyte.persistence.repositories.MealRepository;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import com.delivery.servebyte.services.restaurant.restaurant_manager.RestaurantService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    DeliveryCompanyRepository deliveryCompanyRepository;
    @Autowired
    MealRepository mealRepository;

    /*
      Create proper Exception/error handling classes
     */
    @Override
    public boolean createRestaurant(RestaurantRequest request) {
        String hash = PasswordEncoderUtil.encode(request.getPassword());

        Restaurant restaurant = new Restaurant();
        restaurant.setCreated_on(new Timestamp(new Date().getTime()));
        restaurant.setEmail(request.getEmail());
        restaurant.setLogo(request.getLogo());
        restaurant.setName(request.getRestaurantName());
        restaurant.setPhoneNumber(request.getPhoneNumber());
        restaurant.setPassword(hash);
        restaurant.setCity(request.getCity());
        restaurant.setMeals(request.getMeals());
        this.setDeliveryCompany(request, restaurant);

        try {
            restaurantRepository.save(restaurant);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    This is for creating meals after a restaurant has been created.
    [meals can be created while a restaurant is being created]
     */
    @Override
    public boolean createMeal(@NotNull MealRequest request) {
        Optional<Restaurant> restaurant = restaurantRepository.findByEmail(request.getEmail());

        String hash = restaurant.isPresent() ? restaurant.get().getPassword() : "";
        boolean verified = PasswordEncoderUtil.decode(hash, request.getPassword());

        if (verified) {
            Meal meal = new Meal();
            meal.setName(request.getMealName());
            meal.setDescription(request.getDescription());
            meal.setPhoto(request.getPhoto());
            meal.setPreparationTime(request.getPreparationTime());
            meal.setPrice(request.getPrice());
            try {
                mealRepository.save(meal);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public RestaurantResponse getRestaurant(Long id) {
        RestaurantResponse response = new RestaurantResponse();

        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        if (restaurant.isPresent()) {
            response.setPhoneNumber(restaurant.get().getPhoneNumber());
            response.setMeal(restaurant.get().getMeals());
            response.setLogo(restaurant.get().getLogo());
            response.setEmail(restaurant.get().getEmail());
            response.setName(restaurant.get().getName());
            response.setCity(restaurant.get().getCity());
            response.setDeliveryCompanies(restaurant.get().getDeliveryCompanies());
        }
        return response;
    }

    @Override
    public List<RestaurantResponse> listRestaurants() {
        RestaurantResponse restaurantResponse = new RestaurantResponse();
        List<RestaurantResponse> restaurantResponses = new ArrayList<>();

        List<Restaurant> restaurants = restaurantRepository.findAll();

        if (!restaurants.isEmpty()) {
            restaurants.forEach(restaurant -> {
                restaurantResponse.setName(restaurant.getName());
                restaurantResponse.setCity(restaurant.getCity());
                restaurantResponse.setDeliveryCompanies(restaurant.getDeliveryCompanies());
                restaurantResponse.setEmail(restaurant.getEmail());
                restaurantResponse.setLogo(restaurant.getLogo());
                restaurantResponse.setMeal(restaurant.getMeals());
                restaurantResponse.setPhoneNumber(restaurant.getPhoneNumber());
                restaurantResponses.add(restaurantResponse);
            });
            return restaurantResponses;
        }
        return null;
    }

    @Override
    public Collection<MealRestaurantResponse> searchMealInRestaurants(String mealName) {
        Collection<MealResponse> mealsContainingName = mealRepository.findByNameContaining(mealName);
        MealRestaurantResponse mealAndRestaurantResponse = new MealRestaurantResponse();
        Collection<MealRestaurantResponse> mealAndRestaurantResults = new ArrayList<>();

        mealsContainingName.forEach(meal -> {
            Optional<Restaurant> restaurant = restaurantRepository.findById(meal.getRestaurant_Fk());
            if (restaurant.isPresent()) {
                mealAndRestaurantResponse.setMealId(meal.getId());
                mealAndRestaurantResponse.setMealName(meal.getName());
                mealAndRestaurantResponse.setMealPreparationTime(meal.getPreparationTime());
                mealAndRestaurantResponse.setMealPrice(meal.getPrice());
                mealAndRestaurantResponse.setMealDescription(meal.getDescription());
                mealAndRestaurantResponse.setRestaurantEmail(restaurant.get().getEmail());
                mealAndRestaurantResponse.setCity(restaurant.get().getCity());
                mealAndRestaurantResponse.setRestaurantLogo(restaurant.get().getLogo());
                mealAndRestaurantResponse.setRestaurantName(restaurant.get().getName());
                mealAndRestaurantResponse.setRestaurantPhoneNumber(restaurant.get().getPhoneNumber());

                mealAndRestaurantResults.add(mealAndRestaurantResponse);
            }
        });

        return mealAndRestaurantResults;
    }

    @Override
    public boolean updateRestaurant(Long restaurantId, RestaurantRequest request) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent()) {
            Restaurant restaurantParams = restaurant.get();
            restaurantParams.setName(request.getRestaurantName());
            restaurantParams.setEmail(request.getEmail());
            restaurantParams.setCity(request.getCity());
            restaurantParams.setMeals(request.getMeals());
            restaurantParams.setLogo(request.getLogo());
            restaurantParams.setPhoneNumber(request.getPhoneNumber());
            try {
                restaurantRepository.save(restaurantParams);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent()) {
            restaurantRepository.deleteById(restaurantId);
        }
    }

    private void setDeliveryCompany(@NotNull RestaurantRequest request, Restaurant restaurant) {
        for (String deliveryCompanyName : request.getDeliveryCompany()) {
             Set<DeliveryCompany> deliveryCompany =
                    deliveryCompanyRepository.findByName(deliveryCompanyName);
             restaurant.setDeliveryCompanies(deliveryCompany);
        }
    }
}
