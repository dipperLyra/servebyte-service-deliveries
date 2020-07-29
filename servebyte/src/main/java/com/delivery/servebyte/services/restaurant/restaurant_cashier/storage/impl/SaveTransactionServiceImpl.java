package com.delivery.servebyte.services.restaurant.restaurant_cashier.storage.impl;

import com.delivery.servebyte.dto.mealDTO.CustomerMealRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import com.delivery.servebyte.persistence.entities.Transaction;
import com.delivery.servebyte.persistence.repositories.TransactionRepository;
import com.delivery.servebyte.services.restaurant.restaurant_cashier.storage.SaveTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveTransactionServiceImpl implements SaveTransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public void save(TransactionResponse response, CustomerMealRequest request) {
        Transaction transaction = new Transaction();
        transaction.setAccessCode(response.getData().getAccessCode());
        transaction.setAuthorizationUrl(response.getData().getAuthorizationUrl());
        transaction.setReference(response.getData().getReference());
        transaction.setEmail(request.getEmail());
        transaction.setMealId(request.getMealId());
        transaction.setAmount(request.getTotalPrice());

        transactionRepository.save(transaction);
    }
}
