package com.delivery.servebyte.services.deliverycompany.registration;

import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DeliveryCompanyRegistrationService {

    DeliveryCompany createDeliveryCompany(
            String name,
            String logo,
            String email,
            String password,
            String phoneNumber,
            String channels
    );

    //DeliveryCompany createDeliveryCompany(DeliveryCompany deliveryCompany);

    List<DeliveryCompany> getAllCompanies();
}
