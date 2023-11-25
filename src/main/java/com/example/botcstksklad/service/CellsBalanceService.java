package com.example.botcstksklad.service;

import com.example.botcstksklad.converter.CellsBalanceListToStringConverter;
import com.example.botcstksklad.model.Balance;
import com.example.botcstksklad.model.TyresBalance;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CellsBalanceService {

    public static CellsBalanceListToStringConverter converter = new CellsBalanceListToStringConverter();

    public static String getCellsBalance(String msg) {
        String searchMsg = msg.substring(1);
        List<TyresBalance> cellsBalanceMap = Balance.tyresBalanceList.stream()
                .filter(e -> e.getCells().equalsIgnoreCase(searchMsg))
                .toList();
        return converter.convert(cellsBalanceMap);
    }
}
