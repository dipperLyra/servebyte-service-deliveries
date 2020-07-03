package com.delivery.servebyte.dto.deliveryDTO;

import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@Builder
@ToString
public class DeliveryCompanyResponse {
    private String name;
    private String logo;
    private String email;
    private String phoneNumber;

    private Set<DeliveryChannels> channels;

}
