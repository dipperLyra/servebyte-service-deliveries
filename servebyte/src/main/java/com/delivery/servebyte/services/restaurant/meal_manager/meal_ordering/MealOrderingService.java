package com.delivery.servebyte.services.restaurant.meal_manager.meal_ordering;

import com.delivery.servebyte.dto.mealDTO.CustomerMealRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

public interface MealOrderingService {

    BigDecimal getTotalCost();
    //boolean restaurantAvailableInLocation(Long mealId, String location);
    void setTotalCost(BigDecimal price, int mealQuantity);
    ResponseEntity<TransactionResponse> placeOrder(CustomerMealRequest request);
    void sendEmail();

}
