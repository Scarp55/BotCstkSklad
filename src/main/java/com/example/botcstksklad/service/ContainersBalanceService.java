package com.example.botcstksklad.service;

import com.example.botcstksklad.converter.ContainerBalanceListToStringConverter;
import com.example.botcstksklad.model.Balance;
import com.example.botcstksklad.model.ContainerBalance;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ContainersBalanceService {

    public static ContainerBalanceListToStringConverter containerBalanceListToStringConverter =
            new ContainerBalanceListToStringConverter();

    public static String getContainerBalance(int msg) throws NullPointerException {
        try {
            List<ContainerBalance> containerBalanceList = Balance.containerBalanceList.stream()
                    .filter(e -> e.getSector() / 10 == 70 + msg / 10 && e.getBalance() <= 200)
                    .sorted(Comparator.comparing(ContainerBalance::getBalance).reversed())
                    .toList();
            return containerBalanceListToStringConverter.converter(containerBalanceList);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

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
