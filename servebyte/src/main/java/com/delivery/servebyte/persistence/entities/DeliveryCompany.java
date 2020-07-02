package com.delivery.servebyte.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DeliveryCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "deliveryCompany")
    private Set<DeliveryChannels> deliveryChannels;

    private String name;
    private String logo;
    private String email;
    private String password;
    private String phoneNumber;
    private Date created_on;
}
