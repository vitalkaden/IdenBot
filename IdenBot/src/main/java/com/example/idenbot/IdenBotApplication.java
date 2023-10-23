package com.example.idenbot;

import com.example.idenbot.servises.DownloadFileService;
import com.example.idenbot.servises.DataBaseService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.security.GeneralSecurityException;

@SpringBootApplication
public class IdenBotApplication {
    public IdenBotApplication() throws GeneralSecurityException, IOException {
    }

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        //SpringApplication.run(IdenBotApplication.class, args);

        DownloadFileService downloadFileService = new DownloadFileService();
        DataBaseService dataBaseService = new DataBaseService();

       // downloadFileService.DownloadFile();
        dataBaseService.UploadFile();

//        sheetsService = getSheetsService();
//        String range = "sheet";
//
//        ValueRange response = sheetsService.spreadsheets().values()
//                .get(SPREADSHEET_ID,range)
//                .execute();
//
//        List<List<Object>> values = response.getValues();
//        if (values == null || values.isEmpty()){
//            System.out.println("No data found");
//        }
//        else {
// //           for (List row : values){
// //               System.out.printf("%s\t %s\t %s\t %s\t %s\t %s\n",row.get(0), row.get(1),row.get(2),row.get(3),row.get(4),row.get(5));
//                try (FileOutputStream fos = new FileOutputStream("/Users/twofaced/Documents/Iden-trans/Programm/copyIden - sheet.csv")) {
//                    for (List<Object> row : values) {
//                        String rowData = String.join(" ") + row + "\n";
//                        fos.write(rowData.getBytes());
//                    }
//                    System.out.println("Data downloaded successfully.");
//            }
//        }



//        String jdbcUrl = "jdbc:mysql://localhost:3306/idenBotDb";
//        String userName = "root";
//        String password = "mozgorez2";
//
//        final String filePath = "/Users/twofaced/Documents/Iden-trans/Programm/copyIden - sheet.csv";
//
//        int batchSize = 20;
//
//        Connection connection;
//
//        try {
//            connection = DriverManager.getConnection(jdbcUrl, userName, password);
//            connection.setAutoCommit(false);
//
//            String insertQuery = "insert into idenValidDocTable(ТЗ,Зелена_карта,Білий_сертифікат,Митне_свідоцтво,Тех_огляд,Цивілка,Тахо_сертифікат) values(?,?,?,?,?,?,?)";
//            String truncateQuery = "truncate table idenValidDocTable;";
//            PreparedStatement statementTruncate = connection.prepareStatement(truncateQuery);
//            PreparedStatement statementInsert = connection.prepareStatement(insertQuery);
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
//            statementTruncate.addBatch();
//            statementTruncate.executeBatch();
//
//            String linetext;
//
//            int count = 0;
//
//            bufferedReader.readLine();
//            while((linetext=bufferedReader.readLine())!=null){
//                String replaced = linetext.replaceAll("[\\[\\]\"]", "");
//
//                String[] data = replaced.split(",");
//
//
//                String tz = (data[0]);
//                String green = data[1];
//                String white = data[2];
//                String mytne = data[3];
//                String teh = data[4];
//                String cyvil = data[5];
//                String tacho = data[6];
//
//                statementInsert.setString(1, String.valueOf(tz));
//                statementInsert.setString(2, String.valueOf(green));
//                statementInsert.setString(3, String.valueOf(white));
//                statementInsert.setString(4, String.valueOf(mytne));
//                statementInsert.setString(5, String.valueOf(teh));
//                statementInsert.setString(6, String.valueOf(cyvil));
//                statementInsert.setString(7, String.valueOf(tacho));
//
//                statementInsert.addBatch();
//            }
//
//            bufferedReader.close();
//            statementInsert.executeBatch();
//            connection.commit();
//            connection.close();
//
//            System.out.println("Data has been uploaded successfully");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    }
}

