package com.example.botcstksklad.config;

import com.example.botcstksklad.BotCstkSkladApplicationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class BotConfigTest extends BotCstkSkladApplicationTest {

    @Autowired
    BotConfig botConfig;

    @Test
    void getName() {
        Assertions.assertNotNull(botConfig.getName());
    }

    @Test
    void getToken() {
        Assertions.assertNotNull(botConfig.getToken());
    }
}