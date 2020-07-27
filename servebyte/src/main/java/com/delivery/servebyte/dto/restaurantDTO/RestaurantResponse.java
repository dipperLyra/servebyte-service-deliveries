package com.delivery.servebyte.dto.restaurantDTO;

import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.RestaurantCity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantResponse {

    private String name;
    private String logo;
    private String email;
    private String phoneNumber;
    private List<RestaurantCity> city;
    private Set<Meal> meal;
    private Set<DeliveryCompany> deliveryCompanies;
}
