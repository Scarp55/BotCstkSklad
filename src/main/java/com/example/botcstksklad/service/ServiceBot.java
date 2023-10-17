package com.example.botcstksklad.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

public class ServiceBot {
    public static void getUpdates() throws IOException, InterruptedException {
        int offset = 804731373;
        String uri = "https://api.telegram.org/bot6317386054:AAErUSfEMouiajpULPm2YjZug6XiU9Vwvs4/getUpdates";
        while (true) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"offset\":\"804731375\"}"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ResponseProcess.getOffset(response);
            System.out.println(ResponseProcess.getOffset(response));
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
