package com.delivery.servebyte.dto.mealDTO;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "construct")
public class CustomerMealRequest {

    @NonNull private Long mealId;

    @NonNull private String email;
    @NonNull private String deliveryLocation;
    @NonNull private int mealQuantity;
}
