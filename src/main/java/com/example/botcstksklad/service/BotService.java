package com.example.botcstksklad.service;

import com.example.botcstksklad.model.Bot;
import com.example.botcstksklad.model.Chat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class BotService {

    public static Bot bot;
    static String offset = "1";

    @Autowired
    private BotService(Bot bot) {
        BotService.bot = bot;
    }

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
        return "{" +
                "\"chat_id\":\"" + chat.getChatId() + "\"," +
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
