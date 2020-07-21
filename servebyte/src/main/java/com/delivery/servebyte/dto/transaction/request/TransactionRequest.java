package com.delivery.servebyte.dto.transaction.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class TransactionRequest {

    private String email;
    private BigDecimal amount;
}
