package com.example.botcstksklad.service;

import com.example.botcstksklad.model.Balance;
import com.example.botcstksklad.model.TyresBalance;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.List;

public class TyresBalanceService {

    public void updateTyresBalance(String body) {
        String result = body.substring(body.indexOf(":") + 1, body.length() - 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            List<TyresBalance> tyresBalanceList = mapper.readValue(result, new TypeReference<>() {
            });
            Balance.tyresBalanceList = tyresBalanceList;
            Balance.updateDateTime = LocalDateTime.now();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
