//package com.example.idenbot.servises;
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.client.util.store.FileDataStoreFactory;
//import com.google.api.services.sheets.v4.Sheets;
//import com.google.api.services.sheets.v4.SheetsScopes;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.security.GeneralSecurityException;
//import java.util.Arrays;
//import java.util.List;
//
//public class SheetsAndJava {
//    public static Sheets sheetsService;
//    private static String APLICATION_NAME = "Google sheets Iden";
//    public static final String SPREADSHEET_ID = "1GJkULexvf-WxpBBPl5kItPem-qq_6pnDwYCICdJaX8A";
//            //"1GJkULexvf-WxpBBPl5kItPem-qq_6pnDwYCICdJaX8A";
//
//    private static Credential authorise() throws IOException, GeneralSecurityException {
//        InputStream in = SheetsAndJava.class.getResourceAsStream("/credentials.json");
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
//                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
//        );
//        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
//                clientSecrets,scopes).setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
//                .setAccessType("offline")
//                .build();
//        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver())
//                .authorize("user");
//        return credential;
//    }
//    public static Sheets getSheetsService() throws IOException,GeneralSecurityException{
//        Credential credential = authorise();
//        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
//                JacksonFactory.getDefaultInstance(),credential)
//                .setApplicationName(APLICATION_NAME)
//                .build();
//    }
//}
