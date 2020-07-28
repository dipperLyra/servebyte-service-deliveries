package com.delivery.servebyte.services.restaurant.meal_manager.meal_ordering.impl;

import com.delivery.servebyte.dto.mealDTO.CustomerMealRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.repositories.MealRepository;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import com.delivery.servebyte.projections.MealResponse;
import com.delivery.servebyte.services.restaurant.meal_manager.meal_ordering.MealOrderingService;
import com.delivery.servebyte.services.restaurant.restaurant_cashier.PaystackClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    private BigDecimal mealPrice;
    private BigDecimal totalCost;

    public BigDecimal getTotalCost() {
        return totalCost;
    }


    @Override
    public boolean restaurantAvailableInLocation(Long mealId, String location) {
        var ref = new Object() {
            boolean response = false;
        };

        Optional<MealResponse> meal = mealRepository.findMealById(mealId);

        if (meal.isPresent()) {
            mealPrice = meal.get().getPrice();
        } else
            return false;

        Optional<Restaurant> restaurant = restaurantRepository.findById(meal.get().getRestaurant_Fk());
        if (restaurant.isEmpty())
            return false;

        restaurant.get().getCity().forEach(restaurantCity -> {
            if (location.equals(restaurantCity.getName())) {
                ref.response = true;
            }
        });

        return ref.response;
    }

    @Override
    public void setTotalCost(BigDecimal price, int mealQuantity) {
        totalCost = price.multiply(new BigDecimal(mealQuantity));
    }

    @Override
    public ResponseEntity<TransactionResponse> payment(CustomerMealRequest request) {
        boolean availability =
                this.restaurantAvailableInLocation(request.getMealId(), request.getDeliveryLocation());

        if (availability) {
            this.setTotalCost(mealPrice, request.getMealQuantity());
            return paystackClientService.postTransaction(request);
        }

        return null;
    }

    @Override
    public void sendEmail() {

    }
}
