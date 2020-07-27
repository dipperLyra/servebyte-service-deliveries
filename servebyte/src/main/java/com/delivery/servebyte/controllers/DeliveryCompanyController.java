package com.delivery.servebyte.controllers;

import com.delivery.servebyte.dto.delivery_company.DeliveryCompanyRequest;
import com.delivery.servebyte.dto.delivery_company.DeliveryCompanyResponse;
import com.delivery.servebyte.persistence.repositories.DeliveryCompanyRepository;
import com.delivery.servebyte.services.deliverycompany.registration.DeliveryCompanyRegistrationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/delivery-company")
public class DeliveryCompanyController {

    @Autowired
    DeliveryCompanyRegistrationService deliveryCompanyRegService;
    @Autowired
    DeliveryCompanyRepository deliveryCompanyRepository;

    @GetMapping(path = "/")
    public List<DeliveryCompanyResponse> getAllCompanies() throws NotFoundException {
        return deliveryCompanyRegService.listDeliveryCompanies();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DeliveryCompanyResponse> getDeliveryCompany(
            @PathVariable(value = "id") Long deliveryCompanyId)
    {
        DeliveryCompanyResponse deliveryCompany = deliveryCompanyRegService.getCompany(deliveryCompanyId);

        return ResponseEntity.ok().body(deliveryCompany);
    }

    @PostMapping(path = "/")
    @ResponseBody
    @Transactional
    public ResponseEntity<String> createNewCompany(
            @RequestBody DeliveryCompanyRequest deliveryCompanyRequest)
    {

        if (deliveryCompanyRegService.createDeliveryCompany(deliveryCompanyRequest)) {
            return new ResponseEntity<>("Delivery company created", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Delivery company not created", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<String> removeDeliveryCompany(@RequestParam Long id)
    {
        if (deliveryCompanyRegService.deleteDeliveryCompany(id))
            return new ResponseEntity<>("Delivery company deleted", HttpStatus.OK);
        else return new ResponseEntity<>("Delivery company deleted", HttpStatus.BAD_REQUEST);
    }
}
