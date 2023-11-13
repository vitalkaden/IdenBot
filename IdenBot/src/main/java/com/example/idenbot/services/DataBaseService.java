package com.example.idenbot.services;

import com.example.idenbot.dataBase.DocItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class DataBaseService {

    @PersistenceContext
    EntityManager entityManager;

    final String filePath = "/Users/twofaced/Documents/Iden-trans/Programm/copyIden - sheet-3.csv";

    String truncateQuery = "truncate table iden_valid_doc_table;";

    @Transactional
    @Scheduled(cron = "0/10 * * ? * *")
    public void UploadFile() {
        System.out.println("Uploading");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String nextLine = bufferedReader.readLine();
            entityManager.createNativeQuery(truncateQuery).executeUpdate();
            while ((nextLine = bufferedReader.readLine()) != null) {
                String[] data = nextLine.split(",");

                String tz = (data[0]);
                String green = data[1];
                String white = data[2];
                String mytne = data.length < 4 ? "" : data[3];
                String teh = data.length < 5 ? "" : data[4];
                String cyvil = data.length < 6 ? "" : data[5];
                String tacho = data.length < 7 ? "" : data[6];

                DocItem docItem1 = new DocItem(tz,green,white,mytne,teh,cyvil,tacho);
                entityManager.persist(docItem1);
            }
            bufferedReader.close();
            System.out.println("Uploading complete");

        } catch (Exception e) {
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

}

