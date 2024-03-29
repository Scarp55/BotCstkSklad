package com.example.botcstksklad.converter;

import com.example.botcstksklad.model.ContainerBalance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContainerBalanceListToStringConverter {

    public String converter(List<ContainerBalance> containerBalanceList) {
        StringBuilder sb = new StringBuilder();
        for (ContainerBalance containerBalance : containerBalanceList) {
            sb.append(containerBalance.getName()).append("_")
                    .append(containerBalance.getSector()).append("   ")
                    .append(containerBalance.getBalance()).append("\n");
        }
        return sb.toString();
    }
}
