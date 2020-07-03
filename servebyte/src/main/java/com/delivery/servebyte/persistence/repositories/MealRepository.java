package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.persistence.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    Optional<List<Meal>> findByNameContaining(String name);
}