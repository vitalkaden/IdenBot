package com.example.idenbot;


import com.example.idenbot.config.BotConfig;
import com.example.idenbot.helper.TelegramMenuHelper;
import com.example.idenbot.dataBase.queries.DocItemQuery;
import com.example.idenbot.dataBase.UserItem;
import com.example.idenbot.services.UserService;
import com.example.idenbot.services.CreateMessageService;
import com.example.idenbot.services.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.example.idenbot.helper.TelegramMenuHelper.*;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;
    UserService userRepository;
    SendMessageService sendMessageService;
    CreateMessageService createMessageService;
    TelegramMenuHelper varConstants;
    DocItemQuery docItemRepository;


    @Autowired
    public TelegramBot(BotConfig config, SendMessageService sendMessageService,
                       CreateMessageService createMessageService, TelegramMenuHelper varConstants,
                       DocItemQuery docItemRepository){
        this.config = config;
        this.sendMessageService = sendMessageService;
        this.createMessageService = createMessageService;
        this.varConstants = varConstants;
        this.docItemRepository = docItemRepository;
    }

    @Autowired
    public void setUserRepository(UserService userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String textFromUser = update.getMessage().getText();
            String vehicle = docItemRepository.findByTZ(textFromUser);

            UserItem userItem = new UserItem();
            userItem.setChatId(update.getMessage().getChatId());
            userItem.setFirstName(update.getMessage().getChat().getFirstName());
            userItem.setLastName(update.getMessage().getChat().getLastName());
            userRepository.setUser(userItem);

            if (vehicle != null){
                executeMessage(sendMessageService.getDateFromDb(update,vehicle));
            } else if (varConstants.globMenuList().contains(textFromUser)){
                switch (textFromUser){
                case HELLO,BACK,START -> executeMessage(sendMessageService.greetingMessage(update));
                case TRUCK -> executeMessage(sendMessageService.getTruckMessage(update));
                case TRAILER -> executeMessage(sendMessageService.getTrailerMessage(update));
                case SUBSCRIBTION -> executeMessage(sendMessageService.wannaSubscribtionMessage(update));
                    case SUBSCRIBE -> {
                        executeMessage(sendMessageService.getSubscribtionMessage(update)) ;
                        userRepository.setSubscription(userItem);
                    }
                    case DENY -> {
                        userRepository.denySubscribtion(userItem);
                        executeMessage(sendMessageService.deniSubscribtion(update));
                    }
                }
            } else executeMessage(sendMessageService.getIncorrectCommand(update));
        }
    }

    public  <T extends BotApiMethod> void executeMessage(T sendMessage){
        try{
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return config.botName;
    }

    @Override
    public String getBotToken(){
        return config.token;
    }
}
