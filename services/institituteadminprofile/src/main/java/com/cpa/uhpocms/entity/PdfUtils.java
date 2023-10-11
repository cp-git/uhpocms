package com.cpa.uhpocms.entity;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PdfUtils {
    public static byte[] convertHtmlToPdf(String htmlContent) throws DocumentException, IOException {
        Document document = new Document();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(htmlContent.getBytes(StandardCharsets.UTF_8));
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, inputStream, StandardCharsets.UTF_8);

        document.close();
        writer.close();

        return outputStream.toByteArray();
    }
}
