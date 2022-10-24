package org.example;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

public class PDFGen {
    public static void createNewPDF(Account account, String uri) throws NullPointerException{
        String name = "Files_For_PDFs";
        boolean ifFolderExists = new File(name).mkdir();
        if (ifFolderExists) {
            System.out.println("PDF Folder Created");
        }
        String fileName = account.getFirstName() + "_" + account.getLastName();

        try (OutputStream os = new FileOutputStream(name + "/" + fileName + ".pdf")) {
            PdfRendererBuilder pdfBuilder = new PdfRendererBuilder();
            pdfBuilder.useFastMode();
            pdfBuilder.withUri(uri);
            pdfBuilder.toStream(os);
            pdfBuilder.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
