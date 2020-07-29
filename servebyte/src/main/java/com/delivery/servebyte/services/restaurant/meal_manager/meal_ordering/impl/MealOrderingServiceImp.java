package com.delivery.servebyte.services.restaurant.meal_manager.meal_ordering.impl;

import com.delivery.servebyte.dto.mealDTO.CustomerMealRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.repositories.MealRepository;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import com.delivery.servebyte.projections.MealResponse;
import com.delivery.servebyte.services.restaurant.meal_manager.meal_ordering.MealOrderingService;
import com.delivery.servebyte.services.restaurant.restaurant_cashier.paystack.PaystackClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
/ specify customer location, meal id and quantity
/ check that restaurant is available for location
/
/ calculate the meal price based on quantity + delivery cost
/ prompt user to pay total cost
/ make a Paystack api call with the user's card
/ save transaction,
/ send email for successful payment
// if there's free sms and WhatsApp services, use them as well.
 */
@Service
public class MealOrderingServiceImp implements MealOrderingService {

    @Autowired
    MealRepository mealRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    PaystackClientService paystackClientService;

    Logger logger = LoggerFactory.getLogger(MealOrderingServiceImp.class);

    private BigDecimal mealPrice;
    private BigDecimal totalCost;

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    @Override
    public ResponseEntity<TransactionResponse> placeOrder(CustomerMealRequest request) {
        boolean availability =
                this.restaurantAvailableInLocation(request.getMealId(), request.getDeliveryLocation());
        if (availability && mealPrice.compareTo(request.getTotalPrice()) <= 0) {
            this.setTotalCost(mealPrice, request.getMealQuantity());
            return paystackClientService.postTransaction(request);
        }

        return null;
    }

    private boolean restaurantAvailableInLocation(Long mealId, String location) {
        var ref = new Object() {
            boolean response;
        };

        Optional<MealResponse> meal = mealRepository.findMealById(mealId);
        if (meal.isPresent()) {
            mealPrice = meal.get().getPrice();
        } else
            return false;

        Optional<Restaurant> restaurant = restaurantRepository.findById(meal.get().getRestaurant_Fk());
        if (restaurant.isEmpty()) {
            return false;
        }

        List<String> cities = new ArrayList<>();

        restaurant.get().getCity().forEach(restaurantCity -> {
            cities.add(restaurantCity.getName());
        });

        for (int i = 0; i < cities.size() - 1; i++) {
            if (location.equalsIgnoreCase(cities.get(i))) {
                ref.response = true;
            } else {
                ref.response = false;
            }
        }
        return ref.response;
    }

    @Override
    public void setTotalCost(BigDecimal price, int mealQuantity) {
        totalCost = price.multiply(new BigDecimal(mealQuantity));
    }

    @Override
    public void sendEmail() {

    }
}
