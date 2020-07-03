package com.delivery.servebyte.services.deliverycompany.registration;

import com.delivery.servebyte.PasswordEncoderUtil;
import com.delivery.servebyte.dto.deliveryDTO.DeliveryCompanyBaseRequest;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class DeliveryCompanyRegistrationServiceImpl implements DeliveryCompanyRegistrationService {

    @Autowired
    DeliveryCompanyRepository deliveryCompanyRepository;

    public boolean createDeliveryCompany(DeliveryCompanyBaseRequest deliveryCompanyRequest) {
        DeliveryCompany deliveryCompany = new DeliveryCompany();

        String hash = PasswordEncoderUtil.encode(deliveryCompanyRequest.getPassword());

        deliveryCompany.setPhoneNumber(deliveryCompanyRequest.getPhoneNumber());
        deliveryCompany.setPassword(hash);
        deliveryCompany.setName(deliveryCompanyRequest.getCompanyName());
        deliveryCompany.setLogo(deliveryCompanyRequest.getLogo());
        deliveryCompany.setEmail(deliveryCompanyRequest.getEmail());
        deliveryCompany.setCreatedOn(new Timestamp(new Date().getTime()));
        deliveryCompany.setDeliveryChannels(deliveryCompanyRequest.getChannels());

        deliveryCompanyRepository.save(deliveryCompany);
        return true;
    }

    @Override
    public List<DeliveryCompany> getAllCompanies() {
        return deliveryCompanyRepository.findAll();
    }
}
