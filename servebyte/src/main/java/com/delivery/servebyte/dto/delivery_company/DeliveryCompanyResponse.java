package com.delivery.servebyte.dto.delivery_company;

import com.delivery.servebyte.persistence.entities.DeliveryChannels;
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
     @NonNull String phoneNumber;
     @NonNull Set<DeliveryChannels> deliveryChannels;
     @NonNull Timestamp createdOn;
}
