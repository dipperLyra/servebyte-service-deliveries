package com.delivery.servebyte.services.deliverycompany.registration;

import com.delivery.servebyte.PasswordEncoderUtil;
import com.delivery.servebyte.dto.delivery_company.DeliveryCompanyRequest;
import com.delivery.servebyte.dto.delivery_company.DeliveryCompanyResponse;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryCompanyRegistrationServiceImpl implements DeliveryCompanyRegistrationService {

    @Autowired
    DeliveryCompanyRepository deliveryCompanyRepository;

    public boolean createDeliveryCompany(DeliveryCompanyRequest deliveryCompanyRequest) {
        String hash = PasswordEncoderUtil.encode(deliveryCompanyRequest.getPassword());

        DeliveryCompany deliveryCompany = DeliveryCompany.construct(
                deliveryCompanyRequest.getCompanyName(),
                deliveryCompanyRequest.getLogo(),
                deliveryCompanyRequest.getEmail(),
                hash,
                deliveryCompanyRequest.getPhoneNumber(),
                new Timestamp(new Date().getTime())
        );
        deliveryCompany.setDeliveryChannels(deliveryCompanyRequest.getDeliveryChannels());

        deliveryCompanyRepository.save(deliveryCompany);
        return true;
    }

    @Override
    public List<DeliveryCompanyResponse> listDeliveryCompanies() {
        DeliveryCompanyResponse deliveryCompanyResponse = new DeliveryCompanyResponse();
        List<DeliveryCompanyResponse> responses = new ArrayList<>();

        List<DeliveryCompany> companies = deliveryCompanyRepository.findAll();
        if (!companies.isEmpty()) {
            companies.forEach(company -> {
                deliveryCompanyResponse.setName(company.getName());
                deliveryCompanyResponse.setEmail(company.getEmail());
                deliveryCompanyResponse.setLogo(company.getLogo());
                deliveryCompanyResponse.setPhoneNumber(company.getPhoneNumber());
                deliveryCompanyResponse.setDeliveryChannels(company.getDeliveryChannels());
                deliveryCompanyResponse.setCreatedOn(company.getCreatedOn());
                responses.add(deliveryCompanyResponse);
            });
            return responses;
        }
        return null;
    }

    @Override
    public DeliveryCompanyResponse getCompany(Long id) {
        Optional<DeliveryCompany> deliveryCompany = deliveryCompanyRepository.findById(id);
        DeliveryCompanyResponse response = new DeliveryCompanyResponse();

        if (deliveryCompany.isPresent()) {
            DeliveryCompany company = deliveryCompany.get();

            return DeliveryCompanyResponse.construct(company.getName(), company.getLogo(),
                    company.getEmail(), company.getPhoneNumber(), company.getDeliveryChannels(),
                    company.getCreatedOn());
        } else {
            return response;
        }
    }

    public boolean deleteDeliveryCompany(Long id) {
        Optional<DeliveryCompany> deliveryCompany = deliveryCompanyRepository.findById(id);
        if (deliveryCompany.isPresent()) deliveryCompanyRepository.deleteById(id);
        else return false;

        return true;
    }
}
