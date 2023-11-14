package com.example.botcstksklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ContainerBalance {

    @JsonProperty("СкладскаяЯчейка")
    private String name;

    @JsonProperty("Подразделение")
    private Integer sector;

    @JsonProperty("КонечныйОстаток")
    private Integer balance;

}
