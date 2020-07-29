package com.delivery.servebyte.dto.mealDTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "construct")
public class CustomerMealRequest {

    @NonNull
    @JsonProperty("meal_id")
    private Long mealId;

    @NonNull
    private String email;

    @NonNull
    @JsonProperty("delivery_location")
    private String deliveryLocation;

    @NonNull
    @JsonProperty("meal_quantity")
    private int mealQuantity;

    @NonNull
    @JsonProperty("total_price")
    private BigDecimal totalPrice;
}
