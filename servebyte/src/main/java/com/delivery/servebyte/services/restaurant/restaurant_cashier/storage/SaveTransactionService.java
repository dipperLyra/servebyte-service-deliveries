package com.delivery.servebyte.services.restaurant.restaurant_cashier.storage;

import com.delivery.servebyte.dto.mealDTO.CustomerMealRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import org.springframework.http.ResponseEntity;

public interface SaveTransactionService {
    void save(TransactionResponse response, CustomerMealRequest request);
}
