package com.delivery.servebyte.dto.deliveryDTO;

import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DeliveryCompanyBaseRequest {
    // core delivery company details
    private String companyName;
    private String logo;
    private String email;
    private String phoneNumber;
    private String password;

    // delivery channels
    private Set<DeliveryChannels> channels;

}
