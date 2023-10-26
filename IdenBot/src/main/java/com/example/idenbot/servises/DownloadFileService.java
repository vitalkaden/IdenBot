package com.example.idenbot.servises;


import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import static com.example.idenbot.servises.SheetsAndJava.SPREADSHEET_ID;

@Service
public class DownloadFileService {

    public void DownloadFile() {
        String range = "sheet";

        ValueRange response = null;
        try {
            response = SheetsAndJava.getSheetsService().spreadsheets().values()
                    .get(SPREADSHEET_ID, range)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found");
        } else {
            //           for (List row : values){
            //               System.out.printf("%s\t %s\t %s\t %s\t %s\t %s\n",row.get(0), row.get(1),row.get(2),row.get(3),row.get(4),row.get(5));
            try (FileOutputStream fos = new FileOutputStream("/Users/twofaced/Documents/Iden-trans/Programm/copyIden - sheet.csv")) {
                for (List<Object> row : values) {
                    String rowData = String.join(" ") + row + "\n";
                    fos.write(rowData.getBytes());
                }
                System.out.println("Data downloaded successfully.");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}