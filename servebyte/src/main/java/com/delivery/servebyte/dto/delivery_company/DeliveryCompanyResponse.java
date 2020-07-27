package com.delivery.servebyte.dto.delivery_company;

import com.delivery.servebyte.persistence.entities.DeliveryChannels;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "construct")
public class DeliveryCompanyResponse {
     @NonNull String name;
     @NonNull String logo;
     @NonNull String email;
     @JsonProperty("phone_number")
     @NonNull String phoneNumber;
     @JsonProperty("delivery_channels")
     @NonNull Set<DeliveryChannels> deliveryChannels;
     @JsonProperty("created_on")
     @NonNull Timestamp createdOn;
}
