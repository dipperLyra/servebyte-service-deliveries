package com.delivery.servebyte.services.deliverycompany.registration;

import com.delivery.servebyte.dto.delivery_company.DeliveryCompanyRequest;
import com.delivery.servebyte.dto.delivery_company.DeliveryCompanyResponse;

import java.util.List;

public interface DeliveryCompanyRegistrationService {

    boolean createDeliveryCompany(DeliveryCompanyRequest deliveryCompanyRequest);
    DeliveryCompanyResponse getCompany(Long id);
    List<DeliveryCompanyResponse> listDeliveryCompanies();
    boolean deleteDeliveryCompany(Long id);
}
