package com.example.botcstksklad.model;

import lombok.Getter;

@Getter
public class TestModels {

    String strTest = "{\"ok\":true,\"result\":[{\n" +
            "804731404,\n" +
            "\"message\":{\"message_id\":47,\"from\":{\"id\":2121872245,\"is_bot\":false,\"first_name\":\"Scarp55\",\"username\":\"Scarp55\",\"language_code\":\"ru\"},\"chat\":{\"id\":2121872245,\"first_name\":\"Scarp55\",\"username\":\"Scarp55\",\"type\":\"private\"},\"date\":1697726845,\"text\":\"raz\"}},{\n" +
            "804731405,\n" +
            "\"message\":{\"message_id\":48,\"from\":{\"id\":2121872245,\"is_bot\":false,\"first_name\":\"Scarp55\",\"username\":\"Scarp55\",\"language_code\":\"ru\"},\"chat\":{\"id\":2121872245,\"first_name\":\"Scarp55\",\"username\":\"Scarp55\",\"type\":\"private\"},\"date\":1697726847,\"text\":\"dva\"}},{\n" +
            "804731406,\n" +
            "\"message\":{\"message_id\":49,\"from\":{\"id\":2121872245,\"is_bot\":false,\"first_name\":\"Scarp55\",\"username\":\"Scarp55\",\"language_code\":\"ru\"},\"chat\":{\"id\":2121872245,\"first_name\":\"Scarp55\",\"username\":\"Scarp55\",\"type\":\"private\"},\"date\":1697726849,\"text\":\"tri\"}}]}\n";

    String response = "{\"ok\":true,\"result\":[{\"update_id\":804731406,\n" +
            "\"message\":{\"message_id\":49,\"from\":{\"id\":2121872245,\"is_bot\":false,\"first_name\":\"Scarp55\",\"username\":\"Scarp55\",\"language_code\":\"ru\"},\"chat\":{\"id\":2121872245,\"first_name\":\"Scarp55\",\"username\":\"Scarp55\",\"type\":\"private\"},\"date\":1697726849,\"text\":\"tri\"}}]}\n";

}