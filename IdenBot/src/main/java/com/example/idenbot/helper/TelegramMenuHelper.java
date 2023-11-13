package com.example.idenbot.helper;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramMenuHelper {
    //Messages
    public final static String greetingMessage = "Hello,i can help you";
    public final static String incorrectComand = "Sorry,try again";
    public final static String chooseTruck = "Select TRUCK";
    public final static String chooseTrailer = "Select TRAILER";
    public final static String wannaSubscribe = "Wanna subscribe?!";
    public final static String youHaveBeenSubscribed = "You have been subscribed!";
    public final static String denySubscribtion = "Your subscribtion was denied!";
    //MainMenu
    public static final String START = "/start";
    public static final String HELLO = "hello";
    public static final String BACK = "Back";
    public static final String TRUCK = "TRUCK";
    public static final String TRAILER = "TRAILER";
    public static final String SUBSCRIBTION = "SUBSCRIBTION";
    public static final String SUBSCRIBE = "SUBSCRIBE";
    public static final String DENY = "DENY";

    public List<String> globMenuList(){
        return List.of(START,HELLO,BACK,TRUCK,TRAILER,
                SUBSCRIBTION,SUBSCRIBE,DENY);
    }
}
