package com.delivery.servebyte.controllers;

import com.delivery.servebyte.dto.transaction.request.TransactionRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import com.delivery.servebyte.services.restaurant.restaurant_cashier.impl.PaystackClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/transaction")
public class TransactionController {

    @Autowired
    PaystackClientServiceImpl clientService;
/*
    @PostMapping(path = "/")
    @ResponseBody
    public ResponseEntity<TransactionResponse> newTransaction(@RequestBody TransactionRequest request)
    {
        ResponseEntity<TransactionResponse> response = clientService.postTransaction(request);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Transaction successful");
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response.getBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/test")
    public void tester(@RequestBody TransactionResponse transactionResponse) {
        clientService.testEnv(transactionResponse);
    }*/
}
