package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.persistence.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
}