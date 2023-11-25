package com.example.botcstksklad.model.body;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    @JsonProperty("update_id")
    Integer updateId;

    @JsonProperty("message")
    Message message;
}
