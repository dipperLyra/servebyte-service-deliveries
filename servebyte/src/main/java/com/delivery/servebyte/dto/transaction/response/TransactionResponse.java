package com.delivery.servebyte.dto.transaction.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransactionResponse {
    private boolean status;
    private String message;
    private PaystackResponseData data;
}
