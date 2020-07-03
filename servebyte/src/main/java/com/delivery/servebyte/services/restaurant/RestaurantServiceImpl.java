package com.delivery.servebyte.services.restaurant;

import com.delivery.servebyte.dto.restaurantDTO.RestaurantRequest;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.entities.RestaurantDeliveryCompany;
import com.delivery.servebyte.persistence.repositories.DeliveryChannelRepository;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import com.delivery.servebyte.persistence.repositories.RestaurantDeliveryCompanyRepository;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    DeliveryChannelRepository channelRepository;
    @Autowired
    DeliveryCompanyRepository deliveryCompanyRepository;
    @Autowired
    RestaurantDeliveryCompanyRepository restaurantDeliveryCompanyRepository;

    @Override
    public boolean createRestaurant(RestaurantRequest request) {

        Restaurant restaurant = new Restaurant();

        restaurant.setCreated_on(new Timestamp(new Date().getTime()));
        restaurant.setEmail(request.getEmail());
        restaurant.setLogo(request.getLogo());
        restaurant.setName(request.getRestaurantName());
        restaurant.setPhoneNumber(request.getPhoneNumber());
        restaurant.setPassword(request.getPassword());

        restaurant.setCity(request.getCity());
        restaurant.setMeals(request.getMeals());

        this.deliveryCompanySet(request, restaurant);

        restaurantRepository.save(restaurant);
        return true;
    }

    public void deliveryCompanySet(RestaurantRequest request, Restaurant restaurant) {

        for (String deliveryCompanyName:request.getDeliveryCompany()) {
             Set<DeliveryCompany> deliveryCompany =
                    deliveryCompanyRepository.findByName(deliveryCompanyName);

             restaurant.setDeliveryCompanies(deliveryCompany);
        }
    }
}
