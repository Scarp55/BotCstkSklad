package com.example.botcstksklad.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerBalance {

    @JsonProperty("СкладскаяЯчейка")
    private String name;

    @JsonProperty("Подразделение")
    private Integer sector;

    @JsonProperty("КонечныйОстаток")
    private Integer balance;

    public void setBalance(Integer balance) {
        this.balance = Objects.requireNonNullElse(balance, 0);
    }
}
