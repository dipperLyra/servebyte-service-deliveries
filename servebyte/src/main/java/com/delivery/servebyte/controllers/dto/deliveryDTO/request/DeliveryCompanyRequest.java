package com.delivery.servebyte.controllers.dto.deliveryDTO.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryCompanyRequest {
    private String companyName;
    private String logo;
    private String email;
    private String phoneNumber;
    private String password;
}
