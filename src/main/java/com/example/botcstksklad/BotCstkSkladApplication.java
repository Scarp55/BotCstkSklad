package com.example.botcstksklad;

import com.example.botcstksklad.service.ServiceBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URISyntaxException;

@SpringBootApplication
public class BotCstkSkladApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(BotCstkSkladApplication.class, args);
        ServiceBot.getUpdates();
    }

}
