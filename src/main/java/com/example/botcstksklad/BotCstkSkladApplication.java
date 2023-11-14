package com.example.botcstksklad;

import com.example.botcstksklad.service.BotService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BotCstkSkladApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(BotCstkSkladApplication.class, args);
        BotService.initializationBot();
    }

}
