package com.delivery.servebyte.controllers.data.delivery;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
public class DeliveryCompanyRequest {

    private String name;
    private String logo;
    private String email;
    private String phoneNumber;
    private String password;
}
