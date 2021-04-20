package com.example.goodjobtelegrambot;

import com.example.goodjobtelegrambot.configuration.appConfig.TelegramFacade;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Data
@RequiredArgsConstructor
@Slf4j
public class GoodJobBot extends TelegramWebhookBot {

    private String webHookPath;
    private String userName;
    private String token;

    private TelegramFacade telegramFacade;

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return telegramFacade.handleUpdate(update);
    }
}
