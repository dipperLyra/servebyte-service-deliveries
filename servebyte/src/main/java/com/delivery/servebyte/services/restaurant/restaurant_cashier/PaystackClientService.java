package com.delivery.servebyte.services.restaurant.restaurant_cashier;

import com.delivery.servebyte.dto.mealDTO.CustomerMealRequest;
import com.delivery.servebyte.dto.transaction.request.TransactionRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import com.delivery.servebyte.persistence.entities.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface PaystackClientService {

    ResponseEntity<TransactionResponse> postTransaction(CustomerMealRequest request);
}
