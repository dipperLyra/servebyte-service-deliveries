package com.delivery.servebyte.services.deliverycompany.registration;

import com.delivery.servebyte.dto.deliveryDTO.DeliveryCompanyBaseRequest;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;

import java.util.List;

public interface DeliveryCompanyRegistrationService {

    boolean createDeliveryCompany(DeliveryCompanyBaseRequest deliveryCompanyBaseRequest);


    List<DeliveryCompany> getAllCompanies();
}
