package com.delivery.servebyte.controllers.data.delivery;

import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
    private Set<DeliveryChannels> deliveryChannels = new HashSet<>();
    private String channelName;
    private BigDecimal price;
}
