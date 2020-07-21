package com.delivery.servebyte.dto.mealDTO;

import com.delivery.servebyte.persistence.entities.Restaurant;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


public interface MealResponse {
    String getName();
    BigDecimal getPrice();
    String getPreparationTime();
    String getDescription();
    String getPhoto();
    RestaurantSummary getResturant();

    interface RestaurantSummary {
        String getName();
        String getLogo();
        String getEmail();
    }
}
