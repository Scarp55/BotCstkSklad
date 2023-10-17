package com.example.botcstksklad.service;

import java.net.http.HttpResponse;

public class ResponseProcess {
    public static int getOffset(HttpResponse<String> response){
        String[] arrayResponse = response.body().split("\"update_id\":");
        String lastResponse = arrayResponse[arrayResponse.length-1];
        int lastUpdateId = Integer.parseInt(lastResponse.substring(0, lastResponse.indexOf(",")));
        System.out.println(lastUpdateId);
        return lastUpdateId;
    }
}
