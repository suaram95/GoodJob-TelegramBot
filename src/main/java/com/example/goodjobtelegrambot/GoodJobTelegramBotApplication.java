package com.example.goodjobtelegrambot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@SpringBootApplication
@Slf4j
public class GoodJobTelegramBotApplication {

    public static void main(String[] args) {
        try {
            log.info("Application started");
            TelegramBotsApi telegramBotsApi=new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new GoodJobBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        SpringApplication.run(GoodJobTelegramBotApplication.class, args);
    }

}
