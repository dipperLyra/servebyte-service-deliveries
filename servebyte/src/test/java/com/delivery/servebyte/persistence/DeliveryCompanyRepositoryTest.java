package com.delivery.servebyte.persistence;

import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DeliveryCompanyRepositoryTest {

    @Autowired
    private DeliveryCompanyRepository deliveryCompanyRepository;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindByName() {
        DeliveryCompany deliveryCompany = new DeliveryCompany();
        deliveryCompany.setName("Gokada");
        entityManager.persist(deliveryCompany);
        entityManager.flush();

        Set<DeliveryCompany> deliveryCompanySet = deliveryCompanyRepository.findByName(deliveryCompany.getName());

        for(DeliveryCompany company:deliveryCompanySet) {
            assertThat(company.getName())
                    .isEqualTo(deliveryCompany.getName());
        }
    }
}
