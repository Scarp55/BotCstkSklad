package com.example.botcstksklad.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@NoArgsConstructor
@Setter
@Getter
public class ContainerBalance {

    private String containerBalance;
    private Map<String, Map<String, String>> dataMap;
    private LocalDateTime lastUpdate;
}
