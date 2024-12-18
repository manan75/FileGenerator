package org.example;

import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO extends IOsettings {


    // Constructor for paragraphs
    public IO(String title, String content, String titleFont, int titleFontSize, String titleColor,
              boolean titleBold, boolean titleUnderline, ParagraphAlignment titleAlignment, String contentFont, int contentFontSize,
              String contentColor, boolean contentBold, boolean contentUnderline,ParagraphAlignment contentAlignment) {
        super(title, content,  titleFont,titleFontSize, titleColor,
        titleBold,  titleUnderline,  titleAlignment,  contentFont, contentFontSize,
         contentColor, contentBold,  contentUnderline, contentAlignment);
    }

    // Constructor for points (numbered list)
    public IO(String title, String content, boolean numberedLines, String titleFont, int titleFontSize,
              String titleColor, boolean titleBold, boolean titleUnderline, ParagraphAlignment titleAlignment, String contentFont,
              int contentFontSize, String contentColor, boolean contentBold, boolean contentUnderline, ParagraphAlignment contentAlignment) {
        super(title, content,numberedLines,  titleFont,titleFontSize, titleColor,
                titleBold,  titleUnderline,  titleAlignment,  contentFont, contentFontSize,
                contentColor, contentBold,  contentUnderline, contentAlignment);
    }

    public void appendToWord(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             XWPFDocument document = new XWPFDocument(fis)) {
            // Append title
            XWPFParagraph titleParagraph = document.createParagraph();
            XWPFRun titleRun = titleParagraph.createRun();
            titleParagraph.setAlignment(this.titleAlignment);
            titleRun.setText(this.title);
            titleRun.setFontFamily(this.titleFont);
            titleRun.setFontSize(this.titleFontSize);
            titleRun.setBold(this.titleBold);
            if (this.titleUnderline) titleRun.setUnderline(UnderlinePatterns.SINGLE);
            titleRun.setColor(colorToHex(this.titleColor));

            // Append content
            if (this.numberedLines) {
                // Create a numbered list
                XWPFParagraph contentParagraph = document.createParagraph();
                contentParagraph.setStyle("Numbered");
                contentParagraph.setAlignment(contentAlignment);
                XWPFRun contentRun = contentParagraph.createRun();
                contentRun.setText(this.content);
                contentRun.setFontFamily(this.contentFont);
                contentRun.setFontSize(this.contentFontSize);
                contentRun.setBold(this.contentBold);
                if (this.contentUnderline) contentRun.setUnderline(UnderlinePatterns.SINGLE);
                contentRun.setColor(colorToHex(this.contentColor));
            } else {
                // Normal content paragraph
                XWPFParagraph contentParagraph = document.createParagraph();
                XWPFRun contentRun = contentParagraph.createRun();
                contentParagraph.setAlignment(contentAlignment);
                contentRun.setText(this.content);
                contentRun.setFontFamily(this.contentFont);
                contentRun.setFontSize(this.contentFontSize);
                contentRun.setBold(this.contentBold);
                if (this.contentUnderline) contentRun.setUnderline(UnderlinePatterns.SINGLE);
                contentRun.setColor(colorToHex(this.contentColor));
            }

            // Save the updated document
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                document.write(fos);
            }
            System.out.println("Content appended successfully to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error appending to Word file: " + e.getMessage());
        }
    }

    // Utility method to convert color names to hex codes
    private String colorToHex(String color) {
        switch (color.toLowerCase()) {
            case "red": return "FF0000";
            case "blue": return "0000FF";
            case "green": return "008000";
            case "yellow": return "FFFF00";
            default: return "000000"; // Black as default
        }
    }

}



