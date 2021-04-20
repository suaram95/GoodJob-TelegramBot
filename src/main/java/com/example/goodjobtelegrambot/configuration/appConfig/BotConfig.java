package com.example.goodjobtelegrambot.configuration.appConfig;

import com.example.goodjobtelegrambot.GoodJobBot;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
@Slf4j
public class BotConfig {

    private String webhookPath;
    private String userName;
    private String token;

    @Bean
    public GoodJobBot goodJobBot(){
        GoodJobBot goodJobBot=new GoodJobBot();
        goodJobBot.setUserName(userName);
        log.info("Username {} was set", userName);
        goodJobBot.setToken(token);
        log.info("Token {} was set", token);
        goodJobBot.setWebHookPath(webhookPath);
        log.info("WebHookPath {} was set", webhookPath);
        return goodJobBot;
    }
}
