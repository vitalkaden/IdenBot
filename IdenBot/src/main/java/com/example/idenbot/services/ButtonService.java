package com.example.idenbot.services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class ButtonService {
    public  ReplyKeyboardMarkup getSubscribtionMarkup(){
        ReplyKeyboardMarkup subscribtionMarkup = new ReplyKeyboardMarkup();
        KeyboardRow subscribtionButtons = new KeyboardRow();
        subscribtionButtons.add("SUBSCRIBE");
        subscribtionButtons.add("DENY");
        subscribtionButtons.add("Back");

        List<KeyboardRow>rows = new ArrayList<>();
        rows.add(subscribtionButtons);

        subscribtionMarkup.setKeyboard(rows);
        return subscribtionMarkup;
    }
    public ReplyKeyboardMarkup getGlobalMenuMarkup(){
        ReplyKeyboardMarkup globalMenuMarkup = new ReplyKeyboardMarkup();
        KeyboardRow globalMenuButtons = new KeyboardRow();
        globalMenuButtons.add("TRUCK");
        globalMenuButtons.add("TRAILER");
        globalMenuButtons.add("SUBSCRIBTION");

        List<KeyboardRow>rows = new ArrayList<>();
        rows.add(globalMenuButtons);

        globalMenuMarkup.setKeyboard(rows);
        return globalMenuMarkup;
    }
    public ReplyKeyboardMarkup getTruckNumberMarkup(){
        ReplyKeyboardMarkup truckNumbersMarkup = new ReplyKeyboardMarkup();
        KeyboardRow truckButtonsRow = new KeyboardRow();
        KeyboardRow truckButtonsRow1 = new KeyboardRow();
        KeyboardRow truckButtonsRow2 = new KeyboardRow();
        KeyboardRow truckButtonsRow3 = new KeyboardRow();
        KeyboardRow truckButtonsRow4 = new KeyboardRow();
        KeyboardRow truckButtonsRow5 = new KeyboardRow();
        //1 row of truck buttons
        truckButtonsRow.add("BO1310BH");
        truckButtonsRow.add("BO5020BH");
        truckButtonsRow.add("BO4942BK");
        truckButtonsRow.add("BO4943BK");

        //2 row of truck buttons
        truckButtonsRow1.add("BO8071BH");
        truckButtonsRow1.add("BO8246BI");
        truckButtonsRow1.add("BO8489BM");
        truckButtonsRow1.add("BO7699BM");

        //3 row of truck buttons
        truckButtonsRow2.add("BO3032BM");
        truckButtonsRow2.add("BO0659BM");
        truckButtonsRow2.add("BO5601BO");
        truckButtonsRow2.add("BO8615BT");

        //4 row of truck buttons
        truckButtonsRow3.add("BO2456BH");
        truckButtonsRow3.add("BO9073CK");
        truckButtonsRow3.add("BO9345CX");
        truckButtonsRow3.add("BO5284EE");

        //54 row of truck buttons
        truckButtonsRow4.add("BO0984EE");
        truckButtonsRow4.add("BO4450BX");
        truckButtonsRow4.add("BO4655EI");
        truckButtonsRow4.add("BO5285EE");

        //6 row of truck buttons
        truckButtonsRow5.add("Back");


        List<List<KeyboardRow>>listOfTruckLists = new ArrayList<>();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(truckButtonsRow);
        keyboardRows.add(truckButtonsRow1);
        keyboardRows.add(truckButtonsRow2);
        keyboardRows.add(truckButtonsRow3);
        keyboardRows.add(truckButtonsRow4);
        keyboardRows.add(truckButtonsRow5);

        listOfTruckLists.add(keyboardRows);

        truckNumbersMarkup.setKeyboard(keyboardRows);
        return truckNumbersMarkup;
    }
    public ReplyKeyboardMarkup getTrailerNumberMarkup(){
        ReplyKeyboardMarkup trailerNumberMarkups = new ReplyKeyboardMarkup();
        KeyboardRow trailerButtonsRow = new KeyboardRow();
        KeyboardRow trailerButtonsRow1 = new KeyboardRow();
        KeyboardRow trailerButtonsRow2 = new KeyboardRow();
        KeyboardRow trailerButtonsRow3 = new KeyboardRow();
        KeyboardRow trailerButtonsRow4 = new KeyboardRow();
        KeyboardRow trailerButtonsRow5 = new KeyboardRow();
        trailerButtonsRow.add("BO5496");
        trailerButtonsRow.add("BO4787");
        trailerButtonsRow.add("BO6463");
        trailerButtonsRow.add("BO1706");


        trailerButtonsRow1.add("BO5001");
        trailerButtonsRow1.add("BO5002");
        trailerButtonsRow1.add("BO1980");
        trailerButtonsRow1.add("BO7376");


        trailerButtonsRow2.add("BO1773");
        trailerButtonsRow2.add("BO9739");
        trailerButtonsRow2.add("BO1771");
        trailerButtonsRow2.add("BO8094");


        trailerButtonsRow3.add("BO2828");
        trailerButtonsRow3.add("BO9898");
        trailerButtonsRow3.add("BO3327");
        trailerButtonsRow3.add("BO4251");


        trailerButtonsRow4.add("BO4154");
        trailerButtonsRow4.add("BO7094");
        trailerButtonsRow4.add("BO1372");
        trailerButtonsRow4.add("BO9299");

        trailerButtonsRow5.add("Back");

        List<List<KeyboardRow>>listOfTrailerLists = new ArrayList<>();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        keyboardRows.add(trailerButtonsRow);
        keyboardRows.add(trailerButtonsRow1);
        keyboardRows.add(trailerButtonsRow2);
        keyboardRows.add(trailerButtonsRow3);
        keyboardRows.add(trailerButtonsRow4);
        keyboardRows.add(trailerButtonsRow5);

        trailerNumberMarkups.setKeyboard(keyboardRows);
        return trailerNumberMarkups;
    }
}
