package com.example.botcstksklad.service;

import java.util.Map;
import java.util.stream.Collectors;

import static com.example.botcstksklad.controller.TyresBalanceController.tyresBalance;

public class CreateSendMessage {
    public static String createMessage(String msg) {
        Map<String, Map<String, String>> mapRemainTyresInCell = getMapRemainsTyresInCell(msg.split(" "));

        StringBuilder sb = new StringBuilder();
        for (String nameTyres : mapRemainTyresInCell.keySet()) {
            sb.append(nameTyres).append("\n");
            Map<String, String> mapCells = mapRemainTyresInCell.get(nameTyres);
            for (String nameCells : mapCells.keySet()) {
                String remains = mapCells.get(nameCells);
                sb.append(nameCells).append(" - ").append(remains).append("\n");
            }
        }
        return sb.toString();
    }

    private static Map<String, Map<String, String>> getMapRemainsTyresInCell(String[] arrStr) {
        Map<String, Map<String, String>> mapRemainTyresInCell = tyresBalance.getDataMap();
        for (String str : arrStr) {
            mapRemainTyresInCell = mapRemainTyresInCell.entrySet()
                    .stream()
                    .filter(e -> e.getKey().toLowerCase().contains(str.toLowerCase()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue
                    ));
        }
        return mapRemainTyresInCell;
    }
}
