package com.example.goodjobtelegrambot.configuration.appConfig;

import com.example.goodjobtelegrambot.GoodJobBot;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {

    private String webhookPath;
    private String userName;
    private String token;

    @Bean
    public GoodJobBot goodJobBot(){
        GoodJobBot goodJobBot=new GoodJobBot();
        goodJobBot.setUserName(userName);
        goodJobBot.setToken(token);
        goodJobBot.setWebHookPath(webhookPath);
        return goodJobBot;
    }
}
