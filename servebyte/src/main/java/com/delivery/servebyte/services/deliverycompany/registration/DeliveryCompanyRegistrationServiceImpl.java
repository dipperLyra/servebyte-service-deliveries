package com.delivery.servebyte.services.deliverycompany.registration;

import com.delivery.servebyte.dto.deliveryDTO.DeliveryCompanyBaseRequest;
import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.repositories.DeliveryChannelRepository;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryCompanyRegistrationServiceImpl implements DeliveryCompanyRegistrationService {

    @Autowired
    DeliveryCompanyRepository deliveryCompanyRepository;
    @Autowired
    DeliveryChannelRepository deliveryChannelRepository;

    public boolean createDeliveryCompany(DeliveryCompanyBaseRequest deliveryCompanyRequest) {
        DeliveryCompany deliveryCompany = new DeliveryCompany();
        DeliveryChannels deliveryChannels = new DeliveryChannels();

        deliveryCompany.setPhoneNumber(deliveryCompanyRequest.getPhoneNumber());
        deliveryCompany.setPassword(deliveryCompanyRequest.getPassword());
        deliveryCompany.setName(deliveryCompanyRequest.getCompanyName());
        deliveryCompany.setLogo(deliveryCompanyRequest.getLogo());
        deliveryCompany.setEmail(deliveryCompanyRequest.getEmail());
        deliveryCompany.setDeliveryChannels(deliveryCompanyRequest.getChannels());

        deliveryChannelRepository.save(deliveryChannels);
        deliveryCompanyRepository.save(deliveryCompany);
        return true;
    }

//    @Override
//    public boolean createDeliveryCompany(DeliveryCompanyBaseRequest deliveryCompanyRequest) {
//        String hash = PasswordEncoderGenerator.encode(deliveryCompanyRequest.getPassword());
//
//        // core details
//        DeliveryCompany deliveryCompany = new DeliveryCompany();
//        deliveryCompany.setPhoneNumber(deliveryCompanyRequest.getPhoneNumber());
//        deliveryCompany.setEmail(deliveryCompanyRequest.getEmail());
//        deliveryCompany.setLogo(deliveryCompanyRequest.getLogo());
//        deliveryCompany.setName(deliveryCompanyRequest.getCompanyName());
//        deliveryCompany.setCreatedOn(new Timestamp(new Date().getTime()));
//        deliveryCompany.setPassword(hash);
//        deliveryCompany = deliveryCompanyRepository.save(deliveryCompany);
//
//
//        // delivery channels
//        DeliveryChannels deliveryChannels = new DeliveryChannels();
//
//        for (ChannelRequest channel : deliveryCompanyRequest.getChannels()) {
//            deliveryChannels.setName(channel.getChannelName());
//            deliveryChannels.setPrice(channel.getPrice());
//            deliveryChannels.setCreatedOn(new Timestamp(new Date().getTime()));
//            deliveryChannels = deliveryChannelRepository.save(deliveryChannels);
//        }
//
//
//        Optional<DeliveryCompanyChannel> optionalDeliveryCompanyChannels
//                = deliveryCompanyChannelsRepository
//                .findByDeliveryChannelIdAndDeliveryCompanyId(deliveryChannels.getId(), deliveryCompany.getId());
//
//        if (optionalDeliveryCompanyChannels.isEmpty()) {
//            DeliveryCompanyChannel deliveryCompanyChannels = new DeliveryCompanyChannel();
//            deliveryCompanyChannels.setCreatedOn(new Timestamp(new Date().getTime()));
//            deliveryCompanyChannels.setDeliveryChannelId(deliveryChannels.getId());
//            deliveryCompanyChannels.setDeliveryCompanyId(deliveryCompany.getId());
//            deliveryCompanyChannels.setIsActive(Boolean.TRUE);
//
//            deliveryCompanyChannelsRepository.save(deliveryCompanyChannels);
//        } else {
//
//            DeliveryCompanyChannel deliveryCompanyChannels = optionalDeliveryCompanyChannels.get();
//            deliveryCompanyChannels.setIsActive(Boolean.TRUE);
//
//            deliveryCompanyChannelsRepository.save(deliveryCompanyChannels);
//        }
//        deliveryChannelRepository.save(deliveryChannels);
//        return true;
//    }


    @Override
    public List<DeliveryCompany> getAllCompanies() {
        return deliveryCompanyRepository.findAll();
    }
}
