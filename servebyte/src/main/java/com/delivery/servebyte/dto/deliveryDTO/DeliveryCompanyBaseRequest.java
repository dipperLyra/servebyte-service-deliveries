package com.delivery.servebyte.dto.deliveryDTO;

import com.delivery.servebyte.dto.channelDTO.ChannelRequest;
import com.delivery.servebyte.dto.deliveryDTO.request.DeliveryCompanyRequest;
import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

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
    //private Map<String, ChannelRequest> channels = new HashMap<>();
    private Set<DeliveryChannels> channels;

}
