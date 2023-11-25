package com.example.botcstksklad.service;

import com.example.botcstksklad.converter.TyresBalanceMapToStringConverter;
import com.example.botcstksklad.model.Balance;
import com.example.botcstksklad.model.TyresBalance;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TyresBalanceService {

    public static TyresBalanceMapToStringConverter tyresBalanceMapToStringConverter = new TyresBalanceMapToStringConverter();

    public static String getTyresBalance(String msg) throws NullPointerException {
        try {
            String[] searchText = msg.split(" ");
            List<TyresBalance> tyresBalanceList = Balance.tyresBalanceList;
            for (String str : searchText) {
                tyresBalanceList = tyresBalanceList.stream()
                        .filter(e -> e.getName().toLowerCase().contains(str.toLowerCase()))
                        .toList();
            }
            Map<String, List<TyresBalance>> tyreBalanceMap = tyresBalanceList.stream()
                    .collect(Collectors.groupingBy(TyresBalance::getName));
            return tyresBalanceMapToStringConverter.converter(tyreBalanceMap);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    public void updateTyresBalance(String body) {
        String result = body.substring(body.indexOf(":") + 1, body.length() - 1);
        ObjectMapper mapper = new ObjectMapper();
        try {
            Balance.tyresBalanceList = mapper.readValue(result, new TypeReference<>() {
            });
            Balance.updateDateTime = LocalDateTime.now();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
