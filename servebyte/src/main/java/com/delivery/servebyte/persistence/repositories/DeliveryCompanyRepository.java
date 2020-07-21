package com.delivery.servebyte.persistence.repositories;

import com.delivery.servebyte.projections.DeliveryCompanyResponseInterface;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface DeliveryCompanyRepository extends JpaRepository<DeliveryCompany, Long> {
    @NotNull
    Optional<DeliveryCompany> findById(@NotNull Long id);
    Set<DeliveryCompany> findByName(String name);

    @Query(value =
            "SELECT d.ID, d.CREATED_ON, d.EMAIL, d.LOGO, d.PHONE_NUMBER, DELIVERY_CHANNELS.NAME, DELIVERY_CHANNELS.PRICE \n" +
                    "FROM DELIVERY_COMPANY d \n" +
                    "INNER JOIN DELIVERY_CHANNELS ON d.ID = DELIVERY_CHANNELS.DELIVERY_COMPANY_FK ",
            nativeQuery = true
    )
    List<DeliveryCompanyResponseInterface> findAllCompanies();
}
