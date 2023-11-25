package com.example.botcstksklad.service;

import com.example.botcstksklad.model.Balance;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

import static com.example.botcstksklad.service.BotService.bot;

@Service
public class CreateSendMessageService {

    public static String createSendMessage(String msg) {
        String textCase = (msg.charAt(0) != '.') ? msg : ".";
        try {
            return switch (textCase) {
                case "/start" -> bot.getConfig().getTextHello();
                case "/help" -> bot.getConfig().getTextHelp();
                case "time" -> {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM HH:mm:ss");
                    yield dtf.format(Balance.updateDateTime);
                }
                case "." -> CellsBalanceService.getCellsBalance(msg);
                case "20", "40" -> ContainersBalanceService.getContainerBalance(Integer.parseInt(msg));
                default -> TyresBalanceService.getTyresBalance(msg);
            };
        } catch (NullPointerException e) {
            return "Остатки не обновлены";
        }
    }
}
