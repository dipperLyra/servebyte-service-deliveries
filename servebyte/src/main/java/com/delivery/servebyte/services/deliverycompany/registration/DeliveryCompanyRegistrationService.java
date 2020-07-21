package com.delivery.servebyte.services.deliverycompany.registration;

import com.delivery.servebyte.dto.delivery_company.DeliveryCompanyRequest;
import com.delivery.servebyte.dto.delivery_company.DeliveryCompanyResponse;
import com.delivery.servebyte.projections.DeliveryCompanyResponseInterface;
import javassist.NotFoundException;

import java.util.List;

public interface DeliveryCompanyRegistrationService {

    boolean createDeliveryCompany(DeliveryCompanyRequest deliveryCompanyRequest);
    DeliveryCompanyResponse getCompany(Long id);
    List<DeliveryCompanyResponse> getAllCompanies();
    boolean deleteDeliveryCompany(Long id);
}
