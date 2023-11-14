package com.example.botcstksklad.service;

import com.example.botcstksklad.model.Balance;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ContainersBalanceService {

    public void updateContainersBalance(String body) {
        String result = body.substring(body.indexOf(":") + 1, body.length() - 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Balance.containerBalanceList = mapper.readValue(result, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
