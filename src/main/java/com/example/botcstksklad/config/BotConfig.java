package com.example.botcstksklad.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@PropertySource("classpath:botConfig.properties")
public class BotConfig {

    @Value("${bot.name}")
    String name;

    @Value("${bot.token}")
    String token;

    String textHello = "Привет. Это складской бот компании ЦСТК. " +
            "Я умею показывать остатки шин по ячейкам хранения и контейнерах." +
            "Пока я не умею распознавать русский язык. Но скоро я научусь.";

    String textHelp = "Скоро я помогу тебе научиться управлять мной";
}
