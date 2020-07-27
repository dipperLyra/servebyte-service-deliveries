package com.delivery.servebyte.persistence.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;
    private String logo;
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNumber;
    private Timestamp created_on;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "city_fk")
    private List<RestaurantCity> city;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
    private Set<Meal> meals;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable
    (
            joinColumns = { @JoinColumn(name = "restaurant_id") },
            inverseJoinColumns = { @JoinColumn(name = "delivery_company_id") }
    )
    private Set<DeliveryCompany> deliveryCompanies = new HashSet<>();
}
