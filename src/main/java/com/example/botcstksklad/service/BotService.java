package com.example.botcstksklad.service;

import com.example.botcstksklad.model.Bot;
import com.example.botcstksklad.model.Chat;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;


public class BotService {
    static Bot bot = new Bot();

    static String offset = "1";

    public static void initializationBot() throws IOException, InterruptedException {
        while (true) {
            HttpResponse<String> updates = httpConnection(bot.getUriGetUpdates(), bodyGetUpdates());
            if (updates.body().contains("update_id")) {
                Chat chat = ResponseProcessingService.responseProcessing(updates.body());
                offset = chat.getOffset();
                httpConnection(bot.getUriSendMessage(), getBodySendMessage(chat));
                TimeUnit.SECONDS.sleep(1);
            }
        }

    }

    private static String getBodySendMessage(Chat chat) {
        String msg = CreateSendMessageService.createSendMessage(chat.getReceivedMessage());
        String resultMsg = "{" +
                "\"chat_id\":\"" + chat.getChatId() + "\"," +
                "\"text\":\"" + msg + "\"" +
                "}";
        return resultMsg;
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
