package org.example;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

public class IOsettings {

    public String title;
    public String content;
    public boolean numberedLines;

    // Formatting options
    public String titleFont;
    public int titleFontSize;
    public String titleColor;
    public boolean titleBold;
    public boolean titleUnderline;
    public ParagraphAlignment titleAlignment;

    public String contentFont;
    public int contentFontSize;
    public String contentColor;
    public boolean contentBold;
    public boolean contentUnderline;
    public ParagraphAlignment contentAlignment;

    // Constructor for paragraphs
    public IOsettings(String title, String content, String titleFont, int titleFontSize, String titleColor,
              boolean titleBold, boolean titleUnderline, ParagraphAlignment titleAlignment, String contentFont, int contentFontSize,
              String contentColor, boolean contentBold, boolean contentUnderline,ParagraphAlignment contentAlignment) {
        this.title = title;
        this.content = content;

        // Title formatting
        this.titleFont = titleFont;
        this.titleFontSize = titleFontSize;
        this.titleColor = titleColor;
        this.titleBold = titleBold;
        this.titleUnderline = titleUnderline;
        this.titleAlignment = titleAlignment;

        // Content formatting
        this.contentFont = contentFont;
        this.contentFontSize = contentFontSize;
        this.contentColor = contentColor;
        this.contentBold = contentBold;
        this.contentUnderline = contentUnderline;
        this.contentAlignment = contentAlignment;
    }

    // Constructor for points (numbered list)
    public IOsettings(String title, String content, boolean numberedLines, String titleFont, int titleFontSize,
              String titleColor, boolean titleBold, boolean titleUnderline,ParagraphAlignment titleAlignment, String contentFont,
              int contentFontSize, String contentColor, boolean contentBold, boolean contentUnderline, ParagraphAlignment contentAlignment) {

        this.numberedLines = numberedLines;
        this.title = title;
        this.content = content;

        // Title formatting
        this.titleFont = titleFont;
        this.titleFontSize = titleFontSize;
        this.titleColor = titleColor;
        this.titleBold = titleBold;
        this.titleUnderline = titleUnderline;
        this.titleAlignment = titleAlignment;

        // Content formatting
        this.contentFont = contentFont;
        this.contentFontSize = contentFontSize;
        this.contentColor = contentColor;
        this.contentBold = contentBold;
        this.contentUnderline = contentUnderline;
        this.contentAlignment = contentAlignment;
    }
}
