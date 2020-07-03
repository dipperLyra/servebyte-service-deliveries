package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DeliveryCompanyRepository extends JpaRepository<DeliveryCompany, Long> {
    Set<DeliveryCompany> findByName(String name);

}
