package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface DeliveryCompanyRepository extends JpaRepository<DeliveryCompany, Long> {
}
