package com.delivery.servebyte.dto.mealDTO;

import com.delivery.servebyte.persistence.entities.RestaurantCity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MealRestaurantResponse {
    private String restaurantName;
    private String restaurantLogo;
    private String restaurantEmail;
    private String restaurantPhoneNumber;
    private List<RestaurantCity> city;

    private Long mealId;
    private String mealName;
    private BigDecimal mealPrice;
    private String mealPreparationTime;
    private String mealDescription;
}