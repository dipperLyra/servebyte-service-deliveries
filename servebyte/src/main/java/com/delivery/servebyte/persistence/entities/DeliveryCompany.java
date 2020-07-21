package com.delivery.servebyte.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "construct")
public class DeliveryCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull private String name;
    @NonNull private String logo;
    @NonNull private String email;
    @NonNull private String password;
    @NonNull private String phoneNumber;
    @NonNull private Timestamp createdOn;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "delivery_company_fk")
    @JsonManagedReference
    @NonNull private Set<DeliveryChannels> deliveryChannels = new HashSet<>();
}
