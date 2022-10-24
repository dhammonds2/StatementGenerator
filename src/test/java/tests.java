import junit.framework.TestCase;
import org.example.Account;
import org.example.HTMLGenerator;
import org.example.PDFGen;
import org.example.ReadJSON;
import org.junit.Test;

import java.io.File;

public class tests extends TestCase {
    ReadJSON readZeJson;

    @Test
    void PDFSuccesful(){
        Account accountForTesting = readZeJson.accounts.get(0);
        String filePath = "Files_For_PDFs/Zorina_Tessyman.pdf";
        HTMLGenerator.createAnHTMLFile(accountForTesting);
        String pathFile = HTMLGenerator.getURIFormat(accountForTesting).toString();
        PDFGen.createNewPDF(accountForTesting, pathFile);
        File file = new File(filePath);

        boolean ifExists = file.exists();
        assertTrue(ifExists);

    }
    @Test
    void HTMLSuccessful(){
        Account accountTest = readZeJson.accounts.get(0);
        String paths = "FilesForHTML/Zorina_Tessyman.html";

        HTMLGenerator.createAnHTMLFile(accountTest);
        File file = new File(paths);

        boolean ifExists = file.exists();
        assertTrue(ifExists);
    }
}
