package com.delivery.servebyte.persistence.entities;

import com.delivery.servebyte.dto.transaction.request.TransactionRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
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
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private BigDecimal amount;
    private String authorizationUrl;
    private String accessCode;
    private String reference;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Restaurant restaurant;

    private Long mealId;

    private Timestamp created_on;

    public Transaction (TransactionRequest request, TransactionResponse response) {
        this.amount = request.getAmount();
        this.email = request.getEmail();
        this.authorizationUrl = response.getData().getAuthorizationUrl();
        this.accessCode = response.getData().getAccessCode();
        this.reference = response.getData().getReference();
    }
}
