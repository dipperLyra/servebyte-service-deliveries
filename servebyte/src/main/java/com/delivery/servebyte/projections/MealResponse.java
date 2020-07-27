package com.delivery.servebyte.projections;

import java.math.BigDecimal;

public interface MealResponse {
    Long getId();
    String getName();
    BigDecimal getPrice();
    String getPreparationTime();
    String getDescription();
    String getPhoto();
    Long getRestaurant_Fk();

}
