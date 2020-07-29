package com.delivery.servebyte.services.restaurant.restaurant_cashier.paystack.impl;

import com.delivery.servebyte.dto.mealDTO.CustomerMealRequest;
import com.delivery.servebyte.dto.transaction.response.TransactionResponse;
import com.delivery.servebyte.persistence.repositories.TransactionRepository;
import com.delivery.servebyte.services.restaurant.meal_manager.meal_ordering.MealOrderingService;
import com.delivery.servebyte.services.restaurant.restaurant_cashier.paystack.PaystackClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class PaystackClientServiceImpl implements PaystackClientService {

    @Autowired
    MealOrderingService orderingService;
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    Environment env;
    Logger logger = LoggerFactory.getLogger(PaystackClientServiceImpl.class);


    private final String URI = "https://api.paystack.co/transaction/initialize";

    public ResponseEntity<TransactionResponse> postTransaction(CustomerMealRequest request) {
        HttpHeaders httpHeaders = this.setHttpHeaders();
        Map<String, Object> transactionParams = this.setTransactionParams(request);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(transactionParams, httpHeaders);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TransactionResponse> response = null;
        try {
            response = restTemplate.postForEntity(this.URI, entity, TransactionResponse.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return response;
    }

    private HttpHeaders setHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(Objects.requireNonNull(env.getProperty("paystack.secret")));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    private Map<String, Object> setTransactionParams(CustomerMealRequest request) {
        String[] channels = {"card", "bank"};
        Map<String, Object> map = new HashMap<>();
        map.put("email", request.getEmail());
        map.put("amount", orderingService.getTotalCost());
        //map.put("channels", channels);

        return map;
    }

}
