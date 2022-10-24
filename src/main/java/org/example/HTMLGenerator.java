package org.example;
import java.net.URI;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

public class HTMLGenerator {

    public static void createAnHTMLFile(Account account) {
        String HTMLString = creatingTheHtmlString(account);

        String folderName = "FilesForHTML";
        boolean ifFolderExists = new File(folderName).mkdir();
        if (ifFolderExists) {
            System.out.println("New folder created");
        }
        try {
            String newFileName = account.getFirstName() + "_" + account.getLastName() + ".html";
            File newHtmlFile = new File(folderName + "/" + newFileName);
            FileWriter fw = new FileWriter(folderName + "/" + newFileName);
            fw.write(HTMLString);
            fw.close();
            System.out.println("File Created: " + newHtmlFile.getName());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private static String creatingTheHtmlString(Account account) {
        String html = "<!DOCTYPE html PUBLIC >" + "<head>" + "<title>" + account.getFirstName() + " "
                + account.getLastName() + "</title>" + "</head" + "<body>" + "<h1>Account Number: "
                + account.getAccountNumber() + "," + account.getFirstName() + " " + account.getLastName() + "</h1>"
                + "<p> email: " + account.getEmail() + "</p>" + "<p>Phone: " + account.getPhone() + "</p?"
                + "<p> beginning balance: " + account.getBeginningBalance() + "</p>" + "<p>ssn: " + account.getSsn()
                + "<p>" + "<h2>Stock Statements</h2>";

        for (StockMarketTrades trades : account.getStockTrades()) {
            html += "<ul>" + "<li>Type: " + trades.getType() + "/li> Stock Symbol: " + trades.getStockSymbol() + "</li>"
                    + "<li>Count Shares: " + trades.getCountShares() + "</li>" + "<li>Price per share: "
                    + trades.getPricePerShare() + "</li>" + "</ul>";

        }
        html += "</body></html>";
        return html;
    }

    public static URI getURIFormat(Account newAccount) {
        String name = "Files_For_HTML/" + newAccount.getFirstName() + "_" + newAccount.getLastName() + ".html";
        File thisFile = new File(name);
        return thisFile.toURI();
    }
}
