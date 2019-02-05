import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String... args) throws IOException, DocumentException {
        Document document = new Document();
        document.setPageSize(PageSize.A5);
        document.setMargins(0,0,4,0);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("barcode.pdf"));

        document.open();
        PdfContentByte cb = writer.getDirectContent();

        Barcode128 barcode128 = new Barcode128();
        barcode128.setCode("123456789");
        barcode128.setCodeType(Barcode.CODE128);
        Image code128Image = barcode128.createImageWithBarcode(cb, null, null);
//        document.add(code128Image);
//        document.newPage();

//        Barcode39 barcode39 = new Barcode39();
//        barcode39.setCode("123456789");
//        Image code39Image = barcode39.createImageWithBarcode(cb, null, null);
//        document.add(code39Image);
//        document.newPage();
//
//        BarcodeEAN barcodeEAN = new BarcodeEAN();
//        barcodeEAN.setCode("3210123456789");
//        barcodeEAN.setCodeType(Barcode.EAN13);
//        Image codeEANImage = barcodeEAN.createImageWithBarcode(cb, null, null);
//        document.add(codeEANImage);
//        document.newPage();
//
//        BarcodeQRCode barcodeQRCode = new BarcodeQRCode("000036", 1000, 1000, null);
//        Image codeQrImage = barcodeQRCode.getImage();
//        codeQrImage.scaleAbsolute(100, 100);
//        document.add(codeQrImage);
//
//        document.newPage();

        PdfPTable table = new PdfPTable(3);
        table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
        table.setWidthPercentage(95);
        table.getDefaultCell().setPaddingBottom(11);
        table.getDefaultCell().setPaddingLeft(8);
//        table.getDefaultCell().setPadding(5);
        table.getDefaultCell().setPaddingRight(7);
        for (int aw = 0; aw < 24; aw++) {
            Paragraph p = new Paragraph("JBL Speaker");
            PdfPTable intable = new PdfPTable(1);
//            intable.getDefaultCell().setPadding();
            intable.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
//            intable.getDefaultCell().setBorder(1);
            intable.getDefaultCell().setPaddingLeft(10);
            intable.getDefaultCell().setPaddingRight(10);
            intable.addCell(p);
            intable.addCell(code128Image);
//            intable.getDefaultCell().setBorder(1);
//            intable.getDefaultCell().setPadding(15);
            table.addCell(intable);
        }
        document.add(table);
        document.close();
    }
}
