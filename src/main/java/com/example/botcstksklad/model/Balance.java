package com.example.botcstksklad.model;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
public class Balance {

    public static List<ContainerBalance> containerBalanceList;

    public static List<TyresBalance> tyresBalanceList;

    public static LocalDateTime updateDateTime;

}
