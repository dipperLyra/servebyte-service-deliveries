package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.persistence.entities.RestaurantDeliveryCompany;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RestaurantDeliveryCompanyRepository extends JpaRepository<RestaurantDeliveryCompany, Long> {
    List<RestaurantDeliveryCompany> findByName(String name);
}
