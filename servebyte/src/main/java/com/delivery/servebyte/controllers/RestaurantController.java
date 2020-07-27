package com.delivery.servebyte.controllers;

import com.delivery.servebyte.dto.mealDTO.MealRequest;
import com.delivery.servebyte.dto.mealDTO.MealRestaurantResponse;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.projections.MealResponse;
import com.delivery.servebyte.dto.restaurantDTO.RestaurantRequest;
import com.delivery.servebyte.dto.restaurantDTO.RestaurantResponse;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.repositories.MealRepository;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import com.delivery.servebyte.services.restaurant.RestaurantService;
import com.delivery.servebyte.services.restaurant.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantServiceImpl restaurantServiceImpl;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    MealRepository mealRepository;
    @Autowired
    RestaurantService restaurantService;


    @GetMapping(path = "/")
    public List<Restaurant> getRestaurants() {
        return restaurantRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurant(
            @PathVariable(value = "id") Long restaurantId
    ) {
        RestaurantResponse restaurant = restaurantService.getRestaurant(restaurantId);
        return ResponseEntity.ok().body(restaurant);
    }

    @GetMapping(path = "/meal")
    public ResponseEntity<Collection<MealRestaurantResponse>> mealSearch(
            @RequestParam String meal_name
    ) {
        String mealSet = !meal_name.isEmpty() ? meal_name : "";
        Collection<MealRestaurantResponse> restaurants = restaurantService.searchMealInRestaurants(mealSet);

        return ResponseEntity.ok().body(restaurants);
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseEntity<String> newRestaurant(@RequestBody RestaurantRequest request)
    {
        return restaurantService.createRestaurant(request)
                ? new ResponseEntity<>("restaurant created", HttpStatus.OK)
                : new ResponseEntity<>("restaurant not created", HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/meal")
    @ResponseBody
    public ResponseEntity<String> newMeal(@RequestBody MealRequest request)
    {
        return restaurantService.createMeal(request)
                ? new ResponseEntity<>("meal created", HttpStatus.OK)
                : new ResponseEntity<>("meal not created", HttpStatus.BAD_REQUEST);
    }
}
