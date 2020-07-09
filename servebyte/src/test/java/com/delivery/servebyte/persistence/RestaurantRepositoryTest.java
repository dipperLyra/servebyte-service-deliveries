package com.delivery.servebyte.persistence;

import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.entities.Meal;
import com.delivery.servebyte.persistence.entities.Restaurant;
import com.delivery.servebyte.persistence.entities.RestaurantCity;
import com.delivery.servebyte.persistence.repositories.RestaurantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RestaurantRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindByMealsContaining() {
        Restaurant restaurant = new Restaurant();
        restaurant.setPhoneNumber("08064321467");
        restaurant.setPassword("my_secret");

        Set<DeliveryCompany> companies = new HashSet<>();
        restaurant.setDeliveryCompanies(companies);

        List<RestaurantCity> cities = new ArrayList<>();
        restaurant.setCity(cities);

        entityManager.persist(restaurant);
        entityManager.flush();

    }
}
