package com.delivery.servebyte.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DeliveryCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String logo;
    private String email;
    private String password;
    private String phoneNumber;
    private Timestamp createdOn;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "delivery_company_fk")
    @JsonManagedReference
    private Set<DeliveryChannels> deliveryChannels = new HashSet<>();

}
