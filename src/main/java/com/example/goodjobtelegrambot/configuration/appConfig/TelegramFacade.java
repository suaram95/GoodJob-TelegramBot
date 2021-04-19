package com.example.goodjobtelegrambot.configuration.appConfig;

import com.example.goodjobtelegrambot.configuration.appConfig.cache.UserDataCache;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.goodjobtelegrambot.configuration.appConfig.BotState.*;

@Component
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class TelegramFacade {

    private BotStateContext botStateContext;
    private UserDataCache userDataCache;
//    private MainMenuService mainMenuService;

    public BotApiMethod<?> handleUpdate(Update update){
        SendMessage replyMessage=null;

        if (update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            log.info("New callbackQuery from User: {}, userId: {}, with data: {}",
                    update.getCallbackQuery().getFrom().getUserName(),
                    update.getCallbackQuery().getFrom().getId(),
                    update.getCallbackQuery().getData());
            return processCallbackQuery(callbackQuery);
        }

        Message message = update.getMessage();
        if (message!=null && message.hasText()){
            log.info("New Message from User: {}, userId: {}, chatId:{}, with text: {}",
                    message.getFrom().getUserName(),
                    message.getFrom().getId(),
                    message.getChatId(),
                    message.getText());
            replyMessage= handleMessage(message);
        }
        return replyMessage;
    }

    private SendMessage handleMessage(Message message) {
        String inputMessage = message.getText();
        long userId = message.getFrom().getId();
        BotState botState;
        SendMessage replyMessage;

        switch (inputMessage){
            case "/start":
                botState=SEND_GOOD_JOB;
                break;
            case "/My Good Job list":
                botState=MY_GOOD_JOBS;
                break;
            case "/All Good Jobs":
                botState=ALL_GOOD_JOBS;
                break;
            case "/Members":
                botState=MEMBERS;
            default:
                botState=userDataCache.getUsersCurrentBotState(userId);
                break;
        }
        userDataCache.setUsersCurrentBotState(userId,botState);
        replyMessage=botStateContext.processInputMessage(botState, message);
        return replyMessage;
    }

    private BotApiMethod<?> processCallbackQuery(CallbackQuery callbackQuery) {
        return null;
    }


}
