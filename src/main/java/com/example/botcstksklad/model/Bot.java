package com.example.botcstksklad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Bot {
    final String name = "";
    final String token = "";
    final String uriGetUpdates = "https://api.telegram.org/bot" + token + "/getUpdates";
    final String uriSendMessage = "https://api.telegram.org/bot" + token + "/sendMessage";
    final String uriGetFilePath = "https://api.telegram.org/bot" + token + "/getFile?file_id=";
    final String uriGetFile = "https://api.telegram.org/file/bot" + token + "/";
}
