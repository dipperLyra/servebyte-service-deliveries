package com.delivery.servebyte.controllers;

import com.delivery.servebyte.dto.mealDTO.CustomerMealRequest;
import com.delivery.servebyte.dto.mealDTO.MealRequest;
import com.delivery.servebyte.dto.mealDTO.MealRestaurantResponse;
import com.delivery.servebyte.dto.restaurantDTO.RestaurantRequest;
import com.delivery.servebyte.dto.restaurantDTO.RestaurantResponse;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import com.delivery.servebyte.services.mailpostman.MailManager;
import com.delivery.servebyte.services.restaurant.meal_manager.meal_ordering.MealOrderingService;
import com.delivery.servebyte.services.restaurant.restaurant_cashier.storage.SaveTransactionService;
import com.delivery.servebyte.services.restaurant.restaurant_manager.RestaurantService;
import com.delivery.servebyte.services.restaurant.restaurant_manager.impl.RestaurantServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    RestaurantService restaurantService;
    @Autowired
    MealOrderingService orderingService;
    @Autowired
    SaveTransactionService saveTransactionService;
    @Autowired
    MailManager mailManager;

    Logger logger = LoggerFactory.getLogger(RestController.class);

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

    @PostMapping(path = "/buy")
    @ResponseBody
    public ResponseEntity<TransactionResponse> purchaseMeal(@RequestBody CustomerMealRequest request)
    {
        ResponseEntity<TransactionResponse> response = orderingService.placeOrder(request);
        String subject = "Payment for the meal purchased";
        String text = "Your payment was successful and your order has been fulfilled";

        if (response.getStatusCode() == HttpStatus.OK) {
            saveTransactionService.save(response.getBody(), request);
            mailManager.sendEmail(request.getEmail(), subject, text);
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response.getBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/mail")
    @ResponseBody
    public String mailer() {
        String subject = "Payment for the meal purchased";
        String text = "Your payment was successful and your order has been fulfilled";
        String email = "mkpadikizito@gmail.com";

        mailManager.sendEmail(email, subject, text);
        return "mail sent";

    }
}
