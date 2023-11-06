package com.example.botcstksklad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
public class TyresBalance {

    private String tyresBalance;
    private Map<String, Map<String, String>> dataMap;
    private LocalDateTime lastUpdate;
}
