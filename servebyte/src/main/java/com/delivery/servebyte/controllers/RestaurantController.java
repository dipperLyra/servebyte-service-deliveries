package com.delivery.servebyte.controllers;

import com.delivery.servebyte.dto.restaurantDTO.RestaurantRequest;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.repositories.MealRepository;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import com.delivery.servebyte.services.restaurant.RestaurantService;
import com.delivery.servebyte.services.restaurant.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Restaurant>> getRestaurant(
            @PathVariable(value = "id") Long restaurantId
    ) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        return ResponseEntity.ok().body(restaurant);
    }

    @GetMapping(path = "/meal")
    public ResponseEntity<Optional<List<Meal>>> findRestaurantsWithMeal(
            @RequestParam(required = false) String mealName
    ) {
        String isMealSet = !mealName.isEmpty() ? mealName : "";
        Optional<List<Meal>> restaurants = restaurantService.findRestaurantsAndMeals(isMealSet);

        return ResponseEntity.ok().body(restaurants);
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseEntity<String> newRestaurant(@RequestBody RestaurantRequest request)
    {
        if (restaurantService.createRestaurant(request)) {
            return new ResponseEntity<>("restaurant created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("restaurant not created", HttpStatus.BAD_REQUEST);
        }
    }

}
