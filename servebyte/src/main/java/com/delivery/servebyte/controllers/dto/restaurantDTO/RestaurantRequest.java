package com.delivery.servebyte.controllers.dto.restaurantDTO;

import com.delivery.servebyte.controllers.Cities;
import com.delivery.servebyte.controllers.passwordutils.PasswordEncoderGenerator;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.Restaurant;
import lombok.Builder;
import lombok.ToString;

//@Getter
//@Setter
@Builder
@ToString
public class RestaurantRequest extends Restaurant {

    PasswordEncoderGenerator passwordEncoder;

    private String name;
    private String logo;
    private String email;
    private String password;
    private String phoneNumber;
    private Cities city;
    private Meal meal;
    private DeliveryCompany deliveryCompany;

//    public RestaurantRequest(PasswordEncoderGenerator passwordEncoder, String password) {
//        this.passwordEncoder = passwordEncoder;
//        this.password = this.passwordEncoder.encode(password);
//    }
}
