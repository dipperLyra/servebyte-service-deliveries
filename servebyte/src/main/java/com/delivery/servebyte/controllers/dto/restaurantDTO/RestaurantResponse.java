package com.delivery.servebyte.controllers.dto.restaurantDTO;

import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.entities.Meal;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class RestaurantResponse {

    private String name;
    private String logo;
    private String email;
    private String phoneNumber;
    private String city;
    private Meal meal;
    private DeliveryCompany deliveryCompanies;
}
