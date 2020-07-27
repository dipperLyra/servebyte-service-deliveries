package com.delivery.servebyte.dto.delivery_company;

import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DeliveryCompanyRequest {
    @JsonProperty("company_name")
    private String companyName;
    private String logo;
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    private String password;

    @JsonProperty("delivery_channels")
    private Set<DeliveryChannels> deliveryChannels;

}
