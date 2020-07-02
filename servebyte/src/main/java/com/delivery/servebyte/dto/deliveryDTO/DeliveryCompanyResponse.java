package com.delivery.servebyte.dto.deliveryDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class DeliveryCompanyResponse {
    private String name;
    private String logo;
    private String email;
    private String phoneNumber;
    private String channels;
}
