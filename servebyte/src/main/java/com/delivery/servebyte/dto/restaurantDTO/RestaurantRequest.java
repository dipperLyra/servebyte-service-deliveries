package com.delivery.servebyte.dto.restaurantDTO;

import com.delivery.servebyte.dto.deliveryDTO.request.DeliveryCompanyRequest;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.entities.RestaurantCity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class RestaurantRequest {


    private String restaurantName;
    private String logo;
    private String email;
    private String password;
    private String phoneNumber;

    private List<RestaurantCity> city;
    private Set<Meal> meals;
    private List<String> deliveryCompany;
}
