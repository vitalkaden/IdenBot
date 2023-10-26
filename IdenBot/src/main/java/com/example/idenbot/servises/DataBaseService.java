package com.example.idenbot.servises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseService {
    String jdbcUrl = "jdbc:mysql://localhost:3306/idenBotDb";
    String userName = "root";
    String password = "mozgorez2";


    public void UploadFile(){

        final String filePath = "/Users/twofaced/Documents/Iden-trans/Programm/copyIden - sheet.csv";

        int batchSize = 20;

        Connection connection;

        try {
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            connection.setAutoCommit(false);

            String insertQuery = "insert into idenValidDocTable(ТЗ,Зелена_карта,Білий_сертифікат,Митне_свідоцтво,Тех_огляд,Цивілка,Тахо_сертифікат) values(?,?,?,?,?,?,?)";
            String truncateQuery = "truncate table idenValidDocTable;";
            PreparedStatement statementTruncate = connection.prepareStatement(truncateQuery);
            PreparedStatement statementInsert = connection.prepareStatement(insertQuery);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//            statementTruncate.addBatch();
//            statementTruncate.executeBatch();

            String linetext;

            int count = 0;

            bufferedReader.readLine();
            while((linetext=bufferedReader.readLine())!=null){
                String replaced = linetext.replaceAll("[\\[\\]\"]", "");

                String[] data = replaced.split(",");


                String tz = (data[0]);
                String green = data[1];
                String white = data[2];
                String mytne = data[3];
                String teh = data[4];
                String cyvil = data[5];
                String tacho = data[6];

                statementInsert.setString(1, String.valueOf(tz));
                statementInsert.setString(2, String.valueOf(green));
                statementInsert.setString(3, String.valueOf(white));
                statementInsert.setString(4, String.valueOf(mytne));
                statementInsert.setString(5, String.valueOf(teh));
                statementInsert.setString(6, String.valueOf(cyvil));
                statementInsert.setString(7, String.valueOf(tacho));

                statementInsert.addBatch();
            }

            bufferedReader.close();
            statementInsert.executeBatch();
            connection.commit();
            connection.close();

            System.out.println("Data has been uploaded successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
