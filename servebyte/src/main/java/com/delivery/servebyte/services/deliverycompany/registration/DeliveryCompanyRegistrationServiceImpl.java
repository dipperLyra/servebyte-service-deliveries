package com.delivery.servebyte.services.deliverycompany.registration;

import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryCompanyRegistrationServiceImpl implements DeliveryCompanyRegistrationService {

    DeliveryCompanyRepository deliveryCompanyRepository;

    public DeliveryCompanyRegistrationServiceImpl(DeliveryCompanyRepository deliveryCompanyRepository) {
        this.deliveryCompanyRepository = deliveryCompanyRepository;
    }

    @Override
    public DeliveryCompany createDeliveryCompany(String name, String logo, String email, String password, String phoneNumber, String channels) {
        DeliveryCompany deliveryCompany = new DeliveryCompany();
        deliveryCompany.setName(name);
        deliveryCompany.setLogo(logo);
        deliveryCompany.setEmail(email);
        deliveryCompany.setPassword(password);
        deliveryCompany.setPhoneNumber(phoneNumber);
        return deliveryCompanyRepository.save(deliveryCompany);
    }

//    @Override
//    public DeliveryCompany createDeliveryCompany(DeliveryCompany deliveryCompany) {
//        deliveryCompany.setName(name);
//        deliveryCompany.setLogo(logo);
//        deliveryCompany.setEmail(email);
//        deliveryCompany.setPassword(password);
//        deliveryCompany.setPhoneNumber(phoneNumber);
//        deliveryCompany.setChannels(channels);
//        return deliveryCompanyRepository.save(deliveryCompany);
//    }

    @Override
    public List<DeliveryCompany> getAllCompanies() {
        return deliveryCompanyRepository.findAll();
    }
}
