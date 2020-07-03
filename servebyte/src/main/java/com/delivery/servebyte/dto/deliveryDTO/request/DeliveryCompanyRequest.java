package com.delivery.servebyte.dto.deliveryDTO.request;

import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DeliveryCompanyRequest {
    private String companyName;
    private String logo;
    private String email;
    private String phoneNumber;
    private Set<DeliveryChannels> channels;

}
