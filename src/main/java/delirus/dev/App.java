package delirus.dev;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class App {
    public static void main(String[] args) throws IOException {
        // creating document and page
        PDDocument doc = new PDDocument();
        PDPage pg1 = new PDPage();
        
        // adding text
        PDPageContentStream contentStream = new PDPageContentStream(doc, pg1); 
        contentStream.beginText(); 
        contentStream.setFont(PDType1Font.COURIER, 32);
        contentStream.setLeading(32);
        contentStream.newLineAtOffset(32, 700);

        String line1 = "Creating PDF Document";
        String line2 = "with JAVA";
        String line3 = "and PDFBox";

        contentStream.showText(line1);
        contentStream.newLine();
        contentStream.showText(line2);
        contentStream.newLine();
        contentStream.showText(line3);
        contentStream.endText();

        // adding image
        if(args.length > 0) {
            PDImageXObject pdImg = PDImageXObject.createFromFile(args[0], doc);
            contentStream.drawImage(pdImg, 10, 250);
        }
        
        // adding page and saving document
        contentStream.close();
        doc.addPage(pg1);
        doc.save("myfile.pdf");
        doc.close();
        System.out.println("Document saved!");
    }
}
