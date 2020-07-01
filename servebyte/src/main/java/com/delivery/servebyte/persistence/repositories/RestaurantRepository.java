package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.persistence.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}