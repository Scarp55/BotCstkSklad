package com.example.botcstksklad.service;

import com.example.botcstksklad.model.Chat;
import org.springframework.stereotype.Service;


@Service
public class ResponseProcessingService {
    static Chat chat = new Chat();

    public static Chat responseProcessing(String response) {
        String[] arrayResponse = response.split("\"update_id\":");
        for (String s : arrayResponse) {
            if (s.contains("text")) {
                chat.setChatId(getTextOfResponse(s, "\"chat\":{\"id\":", ","));
                chat.setReceivedMessage(getTextOfResponse(s, "\"text\":\"", "\""));
                chat.setOffset(getOffsetOfResponse(s));
            }
        }
        return chat;
    }

    private static String getOffsetOfResponse(String s) {
        int nextUpdateId = Integer.parseInt(s.substring(0, s.indexOf(","))) + 1;
        return String.valueOf(nextUpdateId);
    }

    public static String getTextOfResponse(String s, String strSearchFist, String strSearchEnd) {
        int indexStart = s.indexOf(strSearchFist) + strSearchFist.length();
        int indexEnd = s.indexOf(strSearchEnd, indexStart);
        return s.substring(indexStart, indexEnd);
    }
}
