package com.delivery.servebyte.persistence.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private BigDecimal price;
    private String preparationTime;
    private String description;
    private String photo;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "restaurant_fk")
    private Restaurant restaurant;

    private Timestamp createdAt;

}
