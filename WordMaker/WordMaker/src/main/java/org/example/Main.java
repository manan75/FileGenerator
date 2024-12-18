package org.example;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import javax.swing.*;
import java.awt.*;

public class Main {
        public static void  main(String[] args) {

                JFrame frame = new JFrame("Word File Generator");

                JLabel titleLabel = new JLabel("Title:");
                JTextField p1Head = new JTextField();
                JLabel contentLabel = new JLabel("Content:");
                JTextArea p1Content = new JTextArea(); // Changed from JTextField to JTextArea


                JButton p1Button = new JButton("Submit");
                JButton search = new JButton("Generate");
                JCheckBox cb1 = new JCheckBox("Numbered list");

                // Font and Style Options
                String[] fontFamilies = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
                String[] fontSizes = {"10", "12", "14", "16", "18", "20", "24", "28", "32"};
                String[] colors = {"Black", "Red", "Blue", "Green", "Yellow"};
                String[] alignments = {"Left", "Center", "Right", "Justify"};


                // Title Field Options
                JComboBox<String> titleFontFamily = new JComboBox<>(fontFamilies);
                JComboBox<String> titleFontSize = new JComboBox<>(fontSizes);
                JComboBox<String> titleFontColor = new JComboBox<>(colors);
                JCheckBox titleBold = new JCheckBox("Bold");
                JCheckBox titleUnderline = new JCheckBox("Underline");
                JComboBox<String> titleAlignmentBox = new JComboBox<>(alignments);


                // Content Field Options
                JComboBox<String> contentFontFamily = new JComboBox<>(fontFamilies);
                JComboBox<String> contentFontSize = new JComboBox<>(fontSizes);
                JComboBox<String> contentFontColor = new JComboBox<>(colors);
                JCheckBox contentBold = new JCheckBox("Bold");
                JCheckBox contentUnderline = new JCheckBox("Underline");
                JComboBox<String> contentAlignmentBox = new JComboBox<>(alignments);

                frame.setSize(1100, 800);
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Positioning Components
                titleLabel.setBounds(30, 50, 100, 30);
                p1Head.setBounds(100, 50, 300, 30);
                titleFontFamily.setBounds(420, 50, 150, 30);
                titleFontSize.setBounds(580, 50, 70, 30);
                titleFontColor.setBounds(660, 50, 100, 30);
                titleBold.setBounds(770, 50, 60, 30);
                titleUnderline.setBounds(840, 50, 100, 30);
                titleAlignmentBox.setBounds(950, 50, 100, 30);

                contentLabel.setBounds(30, 100, 100, 30);
                JScrollPane contentScrollPane = new JScrollPane(p1Content); // Add scroll for JTextArea
                contentScrollPane.setBounds(100, 100, 300, 200);
                contentFontFamily.setBounds(420, 100, 150, 30);
                contentFontSize.setBounds(580, 100, 70, 30);
                contentFontColor.setBounds(660, 100, 100, 30);
                contentBold.setBounds(770, 100, 60, 30);
                contentUnderline.setBounds(840, 100, 100, 30);
                contentAlignmentBox.setBounds(940, 100, 100, 30);

                p1Button.setBounds(100, 350, 100, 30);
                search.setBounds(200, 350,100,30);
                cb1.setBounds(100, 400, 150, 30);

                // Adding Components to Frame
                frame.add(titleLabel);
                frame.add(p1Head);
                frame.add(titleFontFamily);
                frame.add(titleFontSize);
                frame.add(titleFontColor);
                frame.add(titleBold);
                frame.add(titleUnderline);

                frame.add(titleAlignmentBox);
                frame.add(contentAlignmentBox);

                frame.add(contentLabel);
                frame.add(contentScrollPane); // Add scroll pane instead of JTextArea directly
                frame.add(contentFontFamily);
                frame.add(contentFontSize);
                frame.add(contentFontColor);
                frame.add(contentBold);
                frame.add(contentUnderline);

                frame.add(p1Button);
                frame.add(search);
                frame.add(cb1);

                frame.setVisible(true);

                // Action Listener for Submit Button
                p1Button.addActionListener(e -> {
                        String titleText = p1Head.getText();
                        String contentText = p1Content.getText();

                        // Extract Formatting Options
                        String titleFont = (String) titleFontFamily.getSelectedItem();
                        int titleSize = Integer.parseInt((String) titleFontSize.getSelectedItem());
                        String titleColor = (String) titleFontColor.getSelectedItem();
                        boolean isTitleBold = titleBold.isSelected();
                        boolean isTitleUnderline = titleUnderline.isSelected();
                        ParagraphAlignment titleAlign = getAlignment((String) titleAlignmentBox.getSelectedItem());


                        String contentFont = (String) contentFontFamily.getSelectedItem();
                        int contentSize = Integer.parseInt((String) contentFontSize.getSelectedItem());
                        String contentColor = (String) contentFontColor.getSelectedItem();
                        boolean isContentBold = contentBold.isSelected();
                        boolean isContentUnderline = contentUnderline.isSelected();
                        ParagraphAlignment contentAlign = getAlignment((String) contentAlignmentBox.getSelectedItem());

                        // Pass formatting options to the file generation logic
                        IO io = new IO(titleText, contentText, titleFont, titleSize, titleColor, isTitleBold,
                                isTitleUnderline,titleAlign, contentFont, contentSize, contentColor, isContentBold, isContentUnderline, contentAlign);
                        io.appendToWord("C:\\Users\\Manan\\Desktop\\FileGenerator\\india.docx");

                });

        }
        private static ParagraphAlignment getAlignment(String alignment) {
                switch (alignment.toLowerCase()) {
                        case "center":
                                return ParagraphAlignment.CENTER;
                        case "right":
                                return ParagraphAlignment.RIGHT;
                        case "justify":
                                return ParagraphAlignment.BOTH;
                        default:
                                return ParagraphAlignment.LEFT; // Default to left alignment
                }
        }
}

