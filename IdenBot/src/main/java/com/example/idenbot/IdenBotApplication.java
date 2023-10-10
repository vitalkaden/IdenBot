package com.example.idenbot;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static com.example.idenbot.SheetsAndJava.SPREADSHEET_ID;
import static com.example.idenbot.SheetsAndJava.getSheetsService;

@SpringBootApplication
public class IdenBotApplication {


    public static void main(String[] args) throws GeneralSecurityException, IOException {
        SpringApplication.run(IdenBotApplication.class, args);

        Sheets sheetsService;
        sheetsService = getSheetsService();
        String range = "congress!A1:B3";

        ValueRange response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID,range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()){
            System.out.println("No data found");
        }
        else {
            for (List row : values){
                System.out.printf("%s %s from %s\n", row.get(5), row.get(4), row.get(1));
            }
        }
    }

}
