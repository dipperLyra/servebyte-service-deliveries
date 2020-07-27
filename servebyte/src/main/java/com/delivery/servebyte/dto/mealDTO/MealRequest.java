package com.delivery.servebyte.dto.mealDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class MealRequest {

    String email;
    String password;

    @JsonProperty("meal_name")
    private String mealName;
    private BigDecimal price;
    @JsonProperty("preparation_time")
    private String preparationTime;
    private String description;
    private String photo;
}
