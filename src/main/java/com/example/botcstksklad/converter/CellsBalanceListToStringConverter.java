package com.example.botcstksklad.converter;

import com.example.botcstksklad.model.TyresBalance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CellsBalanceListToStringConverter {
    public String convert(List<TyresBalance> cellsBalanceMap) {
        StringBuilder sb = new StringBuilder();
        cellsBalanceMap.forEach(e -> sb.append(e.toCellsString()));
        return sb.toString();
    }
}
