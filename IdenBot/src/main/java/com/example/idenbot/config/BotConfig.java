package com.example.idenbot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class BotConfig {
    @Value("${bot.name}")
    public String botName;
    @Value("${bot.token}")
    public String token;

}
