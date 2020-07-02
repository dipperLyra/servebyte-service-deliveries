package com.delivery.servebyte.controllers.dto.deliveryDTO;

import com.delivery.servebyte.controllers.dto.channelDTO.ChannelRequest;
import com.delivery.servebyte.controllers.dto.deliveryDTO.request.DeliveryCompanyRequest;
import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class DeliveryCompanyBaseRequest {
    // core delivery company details
    private DeliveryCompanyRequest deliveryCompanyRequest;
    private String companyName;
    private String logo;
    private String email;
    private String phoneNumber;
    private String password;

    // delivery channels
    private Set<ChannelRequest> channels = new HashSet<>();

}
