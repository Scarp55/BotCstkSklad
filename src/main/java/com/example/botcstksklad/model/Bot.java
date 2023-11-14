package com.example.botcstksklad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bot {
    String name;
    String token;
    final String uriGetUpdates = "https://api.telegram.org/bot" + token + "/getUpdates";
    final String uriSendMessage = "https://api.telegram.org/bot" + token + "/sendMessage";
}
