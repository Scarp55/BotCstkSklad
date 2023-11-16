package com.example.botcstksklad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@Getter
@Setter
@NoArgsConstructor
@PropertySource("classpath:bot.properties")
public class Bot {

    @Value("${bot.name}")
    String name;

    @Value("${bot.token}")
    String token;

    final String uriGetUpdates = "https://api.telegram.org/bot" + token + "/getUpdates";

    final String uriSendMessage = "https://api.telegram.org/bot" + token + "/sendMessage";
}
