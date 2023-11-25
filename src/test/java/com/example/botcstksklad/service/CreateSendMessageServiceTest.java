package com.example.botcstksklad.service;

import com.example.botcstksklad.BotCstkSkladApplicationTest;
import com.example.botcstksklad.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.example.botcstksklad.service.BotService.bot;


class CreateSendMessageServiceTest extends BotCstkSkladApplicationTest {

    @Autowired
    ContainersBalanceService containersBalanceService;

    @Autowired
    CreateSendMessageService createSendMessageService;

    @Autowired
    TyresBalanceService tyresBalanceService;

    TestUtils testUtils = new TestUtils();

    @BeforeEach
    void init() {

        containersBalanceService.updateContainersBalance(testUtils.getContainerBalance());
        tyresBalanceService.updateTyresBalance(testUtils.getCellsBalance());
    }

    @Test
    void createSendMessageTestContainer20() {

        String result = CreateSendMessageService.createSendMessage("20");

        Assertions.assertEquals(testUtils.getExpectedContainer20(), result);
    }

    @Test
    void createSendMessageTestContainer40() {

        String result = CreateSendMessageService.createSendMessage("40");

        Assertions.assertEquals(testUtils.getExpectedContainer40(), result);
    }

    @Test
    void createSendMessageTestStart() {

        String result = CreateSendMessageService.createSendMessage("/start");

        Assertions.assertEquals(bot.getConfig().getTextHello(), result);
    }

    @Test
    void createSendMessageTestTyresBalance() {

        String result = CreateSendMessageService.createSendMessage("ШиНа 11,5/80-15,3");

        Assertions.assertEquals(testUtils.getExpectedTyresBalance(), result);
    }

    @Test
    void createSendMessageTestHelp() {

        String result = CreateSendMessageService.createSendMessage("/help");

        Assertions.assertEquals(bot.getConfig().getTextHelp(), result);
    }

    @Test
    void createSendMessageTestCellsBalance() {

        String result = CreateSendMessageService.createSendMessage(".у10");

        Assertions.assertEquals(testUtils.getExpectedCellsBalance(), result);
    }
}