package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.projections.MealResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {
    @Query(value =
            "SELECT m.ID, m.NAME, m.PHOTO, m.DESCRIPTION, m.PRICE, m.PREPARATION_TIME, m.RESTAURANT_FK FROM MEAL m \n" +
            "JOIN RESTAURANT r \n" +
            "ON m.RESTAURANT_FK=r.ID WHERE m.NAME LIKE %:name%",
            nativeQuery = true
    )
    Collection<MealResponse> findByNameContaining(@Param("name") String name);

    @Query(value =
            "SELECT m.ID, m.NAME, m.PRICE, m.RESTAURANT_FK FROM MEAL m \n" +
                    "WHERE m.ID = :id",
            nativeQuery = true
          )
    Optional<MealResponse> findMealById(@Param("id") Long id);

    Collection<Meal> findByNameContains(String name);
}