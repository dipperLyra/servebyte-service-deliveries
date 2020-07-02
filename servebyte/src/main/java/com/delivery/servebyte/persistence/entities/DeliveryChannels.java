package com.delivery.servebyte.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DeliveryChannels {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private BigDecimal price;

    private Timestamp createdOn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, targetEntity = DeliveryCompany.class)
    @JoinColumn(name = "delivery_company_fk")
    @JsonBackReference
    private DeliveryCompany deliveryCompany;

}
