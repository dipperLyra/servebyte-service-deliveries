package com.delivery.servebyte.controllers;

import com.delivery.servebyte.controllers.data.delivery.DeliveryCompanyRequest;
import com.delivery.servebyte.controllers.passwordutils.PasswordEncoderGenerator;
import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.repositories.DeliveryChannelRepository;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import com.delivery.servebyte.services.HibernateUtil;
import com.delivery.servebyte.services.deliverycompany.registration.DeliveryCompanyRegistrationService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/delivery-company")
public class DeliveryCompanyController {

    @Autowired
    DeliveryCompanyRegistrationService deliveryCompanyRegService;
    @Autowired
    DeliveryCompanyRepository deliveryCompanyRepository;
    @Autowired
    PasswordEncoderGenerator passwordEncoderGenerator;
    @Autowired
    DeliveryChannelRepository deliveryChannelRepository;

    @GetMapping(path = "/")
    public List<DeliveryCompany> getDeliveryCompanies() {
        return deliveryCompanyRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<DeliveryCompany>> getDeliveryCompany(@PathVariable(value = "id") Long deliveryCompanyId) {
        Optional<DeliveryCompany> deliveryCompany = deliveryCompanyRepository.findById(deliveryCompanyId);
        return ResponseEntity.ok().body(deliveryCompany);
    }

    @PostMapping(path = "/")
    @ResponseBody
    public ResponseEntity<String> newCompany(@RequestBody DeliveryCompanyRequest deliveryCompanyRequest) {
        String hash = PasswordEncoderGenerator.encode(deliveryCompanyRequest.getPassword());

        // core details

//        Session session =  HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();

        DeliveryCompany deliveryCompany = new DeliveryCompany();
        deliveryCompany.setPhoneNumber(deliveryCompanyRequest.getPhoneNumber());
        deliveryCompany.setEmail(deliveryCompanyRequest.getEmail());
        deliveryCompany.setLogo(deliveryCompanyRequest.getLogo());
        deliveryCompany.setName(deliveryCompanyRequest.getCompanyName());
        deliveryCompany.setCreated_on(java.util.Calendar.getInstance().getTime());
        deliveryCompany.setPassword(hash);

        //session.save(deliveryCompany);
        deliveryCompanyRepository.save(deliveryCompany);

        // delivery channels
        DeliveryChannels deliveryChannels = new DeliveryChannels();
        deliveryChannels.setName(deliveryCompanyRequest.getChannelName());
        deliveryChannels.setPrice(deliveryCompanyRequest.getPrice());

        deliveryChannels.setDeliveryCompany(deliveryCompany);
        deliveryCompany.getDeliveryChannels().add(deliveryChannels);

//        session.save(deliveryChannels);
//
//        session.getTransaction().commit();
        deliveryChannelRepository.save(deliveryChannels);
        System.out.println("Done");
        return new ResponseEntity<>("Delivery company created", HttpStatus.OK);
    }
}
