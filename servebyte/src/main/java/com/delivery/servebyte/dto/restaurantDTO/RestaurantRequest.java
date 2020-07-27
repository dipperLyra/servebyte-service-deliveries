package com.delivery.servebyte.dto.restaurantDTO;

import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.RestaurantCity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantRequest {
    @JsonProperty("restaurant_name")
    private String restaurantName;
    private String logo;
    private String email;
    private String password;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private List<RestaurantCity> city;
    private Set<Meal> meals;

    @JsonProperty("delivery_company")
    private List<String> deliveryCompany;
}
