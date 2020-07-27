package com.delivery.servebyte.dto.mealDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class MealResponseDTO {
    private String mealName;
    private BigDecimal mealPrice;
    private String mealPreparationTime;
    private String mealDescription;
    private String mealPhoto;
    private Long restaurantFk;
    private Timestamp createdAt;
}
