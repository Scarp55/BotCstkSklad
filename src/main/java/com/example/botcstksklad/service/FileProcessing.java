package com.example.botcstksklad.service;

import com.example.botcstksklad.model.Chat;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

import static com.example.botcstksklad.controller.TyresBalanceController.tyresBalance;
import static com.example.botcstksklad.service.ServiceBot.bot;

@Service
public class FileProcessing {

    public static void fileProcessing(Chat chat) {
        try {
            String filePath = httpConnection(chat);
            String data = fileBodyProcessing(filePath);
            Map<String, Map<String, String>> mapData = getDataMap(data);
            tyresBalance.setDataMap(mapData);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static Map<String, Map<String, String>> getDataMap(String data) {
        String valueRemains;
        String keyNameCell;
        String keyNameTyres;
        Map<String, Map<String, String>> result = new HashMap<>();
        String[] arrayTyres = data.split("\"ru\",\"Ш");
        for (String arrayTyre : arrayTyres) {
            if (arrayTyre.contains("ина ")) {
                String[] arrayCells = arrayTyre.split("ru\",\"");
                Map<String, String> cellRemains = new HashMap<>();
                keyNameTyres = arrayCells[0].substring(4, arrayCells[0].indexOf("\"}"));
                for (int k = 2; k < arrayCells.length; k = k + 2) {
                    keyNameCell = arrayCells[k].substring(0, arrayCells[k].indexOf("\"}"));
                    if (keyNameCell.equals("Итог")) {
                        break;
                    }
                    valueRemains = arrayCells[k + 1].substring(0, arrayCells[k + 1].indexOf(",000\""));
                    cellRemains.put(keyNameCell, valueRemains);
                }
                result.put(keyNameTyres, cellRemains);
            }
        }
        return result;
    }

    private static String fileBodyProcessing(String filePath) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(bot.getUriGetFile() + filePath))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> data = client.send(request, HttpResponse.BodyHandlers.ofString());
        return data.body();
    }

    private static String httpConnection(Chat chat) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(bot.getUriGetFilePath() + chat.getFileId()))
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> fileInfo = client.send(request, HttpResponse.BodyHandlers.ofString());
        return ResponseProcessing.getTextOfResponse(fileInfo.body(), "file_path\":\"", "\"}}");
    }
}
