package com.example.botcstksklad.service;

import com.example.botcstksklad.model.body.Body;
import com.example.botcstksklad.model.body.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResponseProcessingService {

    static Body body = new Body();

    public static List<Result> responseProcessing(String response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            body = mapper.readValue(response, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return body.getResult();
    }
}
