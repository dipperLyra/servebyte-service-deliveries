package com.delivery.servebyte.dto.payment.paystack;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "construct")
public class PaystackTransactionRequest {

    @NonNull private String email;
    @NonNull private BigDecimal amount;
    private String[] channels;

}
