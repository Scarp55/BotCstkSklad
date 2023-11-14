package com.example.botcstksklad.service;

import com.example.botcstksklad.converter.ContainerBalanceListToStringConverter;
import com.example.botcstksklad.converter.TyresBalanceMapToStringConverter;
import com.example.botcstksklad.model.Balance;
import com.example.botcstksklad.model.ContainerBalance;
import com.example.botcstksklad.model.TyresBalance;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CreateSendMessageService {

    public static TyresBalanceMapToStringConverter tyresBalanceMapToStringConverter =
            new TyresBalanceMapToStringConverter();

    public static ContainerBalanceListToStringConverter containerBalanceListToStringConverter =
            new ContainerBalanceListToStringConverter();

    public static String createSendMessage(String msg) {
        return switch (msg) {
            case "/start" -> "Start!";
            case "time" -> {DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM HH:mm:ss");
                yield dtf.format(Balance.updateDateTime);
            }
            case "help" -> "помощь";
            case "20", "40" -> getContainerBalance(Integer.parseInt(msg));
            default -> msg; //getTyresBalance(msg);
        };
    }

    private static String getTyresBalance(String msg) {
        String[] searchText = msg.split(" ");
        List<TyresBalance> tyresBalanceList = Balance.tyresBalanceList;
        try {
            for (String str : searchText) {
                tyresBalanceList = tyresBalanceList.stream()
                        .filter(e -> e.getName().toLowerCase().contains(str.toLowerCase()))
                        .toList();
            }
        } catch (NullPointerException e) {
            return "Остатки шин не обновлены";
        }
        Map<String, List<TyresBalance>> tyreBalanceMap = tyresBalanceList.stream()
                .collect(Collectors.groupingBy(TyresBalance::getName));
        return tyresBalanceMapToStringConverter.converter(tyreBalanceMap);
    }

    private static String getContainerBalance(int msg) {
        List<ContainerBalance> containerBalanceList;
        try {
            containerBalanceList = Balance.containerBalanceList.stream()
                    .filter(e -> e.getSector() / 10 == 70 + msg / 10 && e.getBalance() <= 200)
                    .sorted(Comparator.comparing(ContainerBalance::getBalance))
                    .toList();
        } catch (NullPointerException e) {
            return "Остатки в контейнерах не обновлены";
        }
        return containerBalanceListToStringConverter.converter(containerBalanceList);
    }
}
