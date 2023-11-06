package com.example.botcstksklad.service;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


class FileProcessingTest {

    private final File file = new File("src/test/resources/", "FileTest.txt");

    private final Map<String, Map<String, String>> result = getDataBase();

    Map<String, Map<String, String>> getDataBase() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
                sb.append(s).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Map<String, Map<String, String>> temp = new HashMap<>();
        String[] arrayTyres = sb.toString().split("\"ru\",\"Ш");
        for (String arrayTyre : arrayTyres) {
            if (arrayTyre.contains("ина ")) {
                String[] arrayCells = arrayTyre.split("ru\",\"");
                Map<String, String> cellRemains = new HashMap<>();
                String valueRemains;
                String keyNameCell;
                String keyNameTyres = arrayCells[0].substring(4, arrayCells[0].indexOf("\"}"));
                for (int k = 2; k < arrayCells.length; k = k + 2) {
                    keyNameCell = arrayCells[k].substring(0, arrayCells[k].indexOf("\"}"));
                    if (keyNameCell.equals("Итог")) {
                        break;
                    }
                    valueRemains = arrayCells[k + 1].substring(0, arrayCells[k + 1].indexOf(",000\""));
                    cellRemains.put(keyNameCell, valueRemains);
                }
                temp.put(keyNameTyres, cellRemains);
            }
        }
//        for (String nameTyres : result.keySet()) {
//            System.out.println(nameTyres);
//            Map<String, String> mapCells = result.get(nameTyres);
//            for (String nameCells : mapCells.keySet()) {
//                String remains = mapCells.get(nameCells);
//                System.out.println(nameCells + "  " + remains);
//            }
//        }
        return temp;
    }

    @Test
    void getRemainsTyresOfCell() {
        Map<String, Map<String, String>> output =
                result.entrySet()
                        .stream()
                        .filter(e -> e.getKey().toLowerCase().contains("135/80R12 Кама 365 (НК-241) 72T".toLowerCase()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        ));
        for (String nameCells : output.keySet()) {
            System.out.println(nameCells);
        }
    }

}