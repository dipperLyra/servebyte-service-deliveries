package com.delivery.servebyte.controllers;

import com.delivery.servebyte.dto.deliveryDTO.DeliveryCompanyBaseRequest;
import com.delivery.servebyte.controllers.passwordutils.PasswordEncoderGenerator;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.repositories.DeliveryChannelRepository;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import com.delivery.servebyte.services.deliverycompany.registration.DeliveryCompanyRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

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
    @Transactional
    public ResponseEntity<String> newCompany1(@RequestBody DeliveryCompanyBaseRequest deliveryCompanyRequest) {

        if (deliveryCompanyRegService.createDeliveryCompany(deliveryCompanyRequest)) {
            return new ResponseEntity<>("Delivery company created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Delivery company not created", HttpStatus.BAD_REQUEST);
        }
    }
}
