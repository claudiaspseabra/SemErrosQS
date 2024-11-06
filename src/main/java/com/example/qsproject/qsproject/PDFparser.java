package com.example.qsproject.qsproject;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;

import java.io.File;
import java.io.IOException;


public class PDFparser {
    public static void main(String[] args) {

        String filePath = "FilesForUs/ClassRooms Info.pdf";

        try {
            PdfDocument pdfDoc = new PdfDocument(new PdfReader(filePath));

            for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {
                String pageText = PdfTextExtractor.getTextFromPage(pdfDoc.getPage(i));
                System.out.println("Page " + i + " Text:");
                System.out.println(pageText);
                System.out.println("-------------------------------------------------");
            }

            pdfDoc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
