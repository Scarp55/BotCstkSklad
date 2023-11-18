package com.example.botcstksklad.model;

import com.example.botcstksklad.config.BotConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@AllArgsConstructor
@Component
public class Bot {

    private BotConfig config;

    public String getUriGetUpdates() {
        return "https://api.telegram.org/bot" + config.getToken() + "/getUpdates";
    }

    public String getUriSendMessage() {
        return "https://api.telegram.org/bot" + config.getToken() + "/sendMessage";
    }
}
