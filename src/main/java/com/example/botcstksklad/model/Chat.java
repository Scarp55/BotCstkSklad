package com.example.botcstksklad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Chat {
    String chatId;
    String receivedMessage;
    String offset;
    String fileId;
}
