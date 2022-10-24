package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:/Users/Dylan/Documents/stock_transations-3.by.account.holder (1).json";

        ReadJSON reader = new ReadJSON(filePath);



            for (Account account : reader.accounts) {
                HTMLGenerator.createAnHTMLFile(account);

                PDFGen.createNewPDF(account, HTMLGenerator.getURIFormat(account).toString());
            }
            System.out.println("Files have been created");
        }


}
