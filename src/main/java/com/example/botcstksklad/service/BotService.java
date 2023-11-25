package com.example.botcstksklad.service;

import com.example.botcstksklad.model.Bot;
import com.example.botcstksklad.model.body.Result;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class BotService {

    public static Bot bot;
    static Integer offset = 1;

    @Autowired
    private BotService(Bot bot) {
        BotService.bot = bot;
    }

    public static void initializationBot() throws IOException, InterruptedException {
        while (true) {
            HttpResponse<String> updates = httpConnection(bot.getUriGetUpdates(), bodyGetUpdates());
            List<Result> results = ResponseProcessingService.responseProcessing(updates.body());
            for (Result result : results) {
                offset = result.getUpdateId() + 1;
                httpConnection(bot.getUriSendMessage(), getBodySendMessage(result));
            }
            TimeUnit.SECONDS.sleep(1);
        }

    }

    private static String getBodySendMessage(Result result) {
        String msg = CreateSendMessageService.createSendMessage(result.getMessage().getText());
        return "{" +
                "\"chat_id\":\"" + result.getMessage().getChat().getId() + "\"," +
                "\"text\":\"" + msg + "\"" +
                "}";
    }

    private static String bodyGetUpdates() {
        return "{" +
                "\"offset\":\"" + offset + "\"" +
                "}";
    }

    private static HttpResponse<String> httpConnection(String uri, String body) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
