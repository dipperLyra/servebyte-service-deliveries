package com.delivery.servebyte.persistence.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DeliveryCompanyChannel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, updatable = false)
    private Long deliveryCompanyId;

    @Column(nullable = false, updatable = false)
    private Long deliveryChannelId;

    private Timestamp createdOn;

    private Boolean isActive;
}
