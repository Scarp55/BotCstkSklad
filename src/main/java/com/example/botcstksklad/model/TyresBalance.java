package com.example.botcstksklad.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class TyresBalance {

    @JsonProperty("Номенклатура")
    private String name;

    @JsonProperty("НоменклатураКод")
    private String code;

    @JsonProperty("СкладскаяЯчейка")
    private String cells;

    @JsonProperty("Подразделение")
    private String sector;

    @JsonProperty("КонечныйОстаток")
    private String balance;

    @Override
    public String toString() {
        return cells + "_" + sector + "  " + balance;
    }

    public String toCellsString() {
        return name + "  " + balance + "\n";
    }
}
