package com.example.botcstksklad.converter;

import com.example.botcstksklad.model.TyresBalance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TyresBalanceMapToStringConverter {

    public String converter(Map<String, List<TyresBalance>> tyreBalanceMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<TyresBalance>> stringListEntry : tyreBalanceMap.entrySet()) {
            sb.append("\n").append(stringListEntry.getKey()).append("\n");
            for (TyresBalance tyresBalance : stringListEntry.getValue()) {
                sb.append(tyresBalance.getCells()).append("_")
                        .append(tyresBalance.getSector()).append("   ")
                        .append(tyresBalance.getBalance()).append("\n");
            }
        }
        return sb.toString();
    }
}
