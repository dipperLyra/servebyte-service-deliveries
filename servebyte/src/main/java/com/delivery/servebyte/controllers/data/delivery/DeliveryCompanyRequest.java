package com.delivery.servebyte.controllers.data.delivery;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryCompanyRequest {
    // core delivery company details
    private String companyName;
    private String logo;
    private String email;
    private String phoneNumber;
    private String password;

    // delivery channels
    private String channelName;
//    private Long companyId;
    private BigDecimal price;
}
