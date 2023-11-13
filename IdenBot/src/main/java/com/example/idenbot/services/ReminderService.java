package com.example.idenbot.services;

import com.example.idenbot.TelegramBot;
import com.example.idenbot.dataBase.DocItem;
import com.example.idenbot.dataBase.queries.DocItemQuery;
import com.example.idenbot.dataBase.UserItem;
import com.example.idenbot.dataBase.queries.UserItemQuery;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    UserItemQuery userRepoJpa;
    CreateMessageService createMessageService;
    TelegramBot telegramBot;
    DocItemQuery docItemRepository;

    public ReminderService(UserItemQuery userRepoJpa, CreateMessageService createMessageService,
                           TelegramBot telegramBot, DocItemQuery docItemRepository) {
        this.userRepoJpa = userRepoJpa;
        this.createMessageService = createMessageService;
        this.telegramBot = telegramBot;
        this.docItemRepository = docItemRepository;
    }

    @Scheduled(cron = "0/310 * * ? * *")
    public void sendRemind(){
        System.out.println("habib 4otkyi tip");
        List<DocItem> allBeforeEnds = docItemRepository.findAllBeforeEnds();
        for (UserItem user : userRepoJpa.allIfTrue()) {
            for (DocItem doc : allBeforeEnds) {
                telegramBot.executeMessage(createMessageService.createMessage(user.getChatId(),doc.toString()));
            }
        }
    }
}