package com.delivery.servebyte.services.transaction;

import com.delivery.servebyte.dto.transaction.request.TransactionRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import com.delivery.servebyte.persistence.entities.Transaction;
import com.delivery.servebyte.persistence.repositories.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class PaystackClientService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    Environment env;
    Logger logger = LoggerFactory.getLogger(PaystackClientService.class);

    public ResponseEntity<TransactionResponse> postTransaction(TransactionRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(Objects.requireNonNull(env.getProperty("paystack.secret")));
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> map = new HashMap<>();
        map.put("email", request.getEmail());
        map.put("amount", request.getAmount());
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        String uri = "https://api.paystack.co/transaction/initialize";
        ResponseEntity<TransactionResponse> response = restTemplate.postForEntity(uri, entity, TransactionResponse.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            Transaction transaction = new Transaction();
            this.setTransaction(request, transaction);
            this.setPayclientResponse(Objects.requireNonNull(response.getBody()), transaction);
            transactionRepository.save(this.setTransaction(request, transaction));
        }
        return response;
    }

    public Transaction setTransaction(TransactionRequest request, Transaction transaction) {
        transaction.setAmount(request.getAmount());
        transaction.setEmail(request.getEmail());
        return transaction;
    }

    public void  setPayclientResponse(TransactionResponse response, Transaction transaction) {
        transaction.setAccessCode(response.getData().getAccessCode());
        transaction.setAuthorizationUrl(response.getData().getAuthorizationUrl());
        transaction.setReference(response.getData().getReference());
    }

    public void testEnv(TransactionResponse responseData) {
        logger.info("got to first");
        logger.info(responseData.getMessage());
        logger.info(responseData.getData().getAuthorizationUrl());
    }
}
