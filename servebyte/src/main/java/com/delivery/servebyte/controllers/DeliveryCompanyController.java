package com.delivery.servebyte.controllers;

import com.delivery.servebyte.controllers.data.delivery.DeliveryCompanyResponse;
import com.delivery.servebyte.controllers.passwordutils.PasswordEncoderGenerator;
import com.delivery.servebyte.persistence.entities.DeliveryCompany;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import com.delivery.servebyte.services.deliverycompany.registration.DeliveryCompanyRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/api/v1")
public class DeliveryCompanyController {

    @Autowired
    DeliveryCompanyRegistrationService deliveryCompanyRegService;
    @Autowired
    DeliveryCompanyRepository deliveryCompanyRepository;
    @Autowired
    PasswordEncoderGenerator passwordEncoderGenerator;

    @GetMapping(path = "/delivery-companies")
    public List<DeliveryCompany> getDeliveryCompanies() {
        return deliveryCompanyRepository.findAll();
    }

    @GetMapping(path = "/delivery-company/{id}")
    public ResponseEntity<Optional<DeliveryCompany>> getDeliveryCompany(@PathVariable(value = "id") Long deliveryCompanyId) {
        Optional<DeliveryCompany> deliveryCompany = deliveryCompanyRepository.findById(deliveryCompanyId);
        return ResponseEntity.ok().body(deliveryCompany);
    }

    @PostMapping(path = "/delivery-company")
    @ResponseBody
    DeliveryCompany newCompany(@RequestBody DeliveryCompany deliveryCompany) {
        return deliveryCompanyRepository.save(deliveryCompany);
    }
}
