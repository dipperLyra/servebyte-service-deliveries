package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.dto.mealDTO.MealResponse;
import com.delivery.servebyte.persistence.entities.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    @Query(value =
            "SELECT m.ID, m.NAME, m.PHOTO, m.DESCRIPTION, m.PRICE, m.PREPARATION_TIME, m.RESTAURANT_FK FROM MEAL m \n" +
            "JOIN RESTAURANT r \n" +
            "ON m.RESTAURANT_FK=r.ID WHERE m.NAME LIKE %:name%",
            nativeQuery = true
    )
    Collection<MealResponse> findByNameContaining(@Param("name") String name);
}