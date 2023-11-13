package com.example.idenbot.services;

import com.example.idenbot.dataBase.queries.DocItemQuery;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

import static com.example.idenbot.helper.TelegramMenuHelper.*;

@Service
public class SendMessageService{
    ButtonService buttonService;
    CreateMessageService createMessageService;
    DocItemQuery docItemRepository;

    public SendMessageService(ButtonService buttonService, CreateMessageService createMessageService,
                              DocItemQuery docItemRepository) {
        this.buttonService = buttonService;
        this.createMessageService = createMessageService;
        this.docItemRepository = docItemRepository;
    }

    public SendMessage deniSubscribtion(Update update){
        SendMessage message = createMessageService.createMessage(update, denySubscribtion);
        return message;
    }
    public SendMessage getSubscribtionMessage(Update update){
        SendMessage message = createMessageService.createMessage(update,youHaveBeenSubscribed);
        return message;
    }
    public  SendMessage wannaSubscribtionMessage(Update update){
        SendMessage message = createMessageService.createMessage(update,wannaSubscribe);
        ReplyKeyboardMarkup markup = buttonService.getSubscribtionMarkup();
        message.setReplyMarkup(markup);
        return message;
    }
    public SendMessage greetingMessage(Update update){
        SendMessage message = createMessageService.createMessage(update,greetingMessage);
        ReplyKeyboardMarkup markup = buttonService.getGlobalMenuMarkup();
        message.setReplyMarkup(markup);
        return message;
    }
    public SendMessage getTruckMessage(Update update){
        SendMessage message = createMessageService.createMessage(update,chooseTruck);
        ReplyKeyboardMarkup markup = buttonService.getTruckNumberMarkup();
        message.setReplyMarkup(markup);
        return message;
    }
    public SendMessage getTrailerMessage(Update update){
        SendMessage message = createMessageService.createMessage(update,chooseTrailer);
        ReplyKeyboardMarkup markup = buttonService.getTrailerNumberMarkup();
        message.setReplyMarkup(markup);
        return message;
    }
    public SendMessage getDateFromDb(Update update, String textFromUser){
        SendMessage message = createMessageService.createMessage(update,textFromUser);
        return message;
    }
    public SendMessage getIncorrectCommand(Update update){
        SendMessage message = createMessageService.createMessage(update,incorrectComand);
        return message;
    }
}
