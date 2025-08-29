package utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExcelWriter {

    public static void writeLanguageAndLevel(List<String> languageList, List<String> levelList, String fileName, String sheetNamePrefix) {
        Workbook workbook;
        Sheet sheet;

        File file = new File(fileName);
        if (file.exists() && file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        } else {
            workbook = new XSSFWorkbook(); // Create new workbook if file doesn't exist or is empty
        }

        // Generate unique sheet name with timestamp
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String sheetName = sheetNamePrefix + "_" + timestamp;
        sheet = workbook.createSheet(sheetName);

        // Create bold style for headers
        CellStyle boldStyle = workbook.createCellStyle();
        Font boldFont = workbook.createFont();
        boldFont.setBold(true);
        boldStyle.setFont(boldFont);

        // Write headers
        Row headerRow = sheet.createRow(0);
        Cell langHeader = headerRow.createCell(0);
        langHeader.setCellValue("Language");
        langHeader.setCellStyle(boldStyle);

        Cell levelHeader = headerRow.createCell(1);
        levelHeader.setCellValue("Level");
        levelHeader.setCellStyle(boldStyle);

        // Determine max row count
        int maxRows = Math.max(languageList.size(), levelList.size());

        // Write data
        for (int i = 0; i < maxRows; i++) {
            Row row = sheet.createRow(i + 1);

            if (i < languageList.size()) {
                row.createCell(0).setCellValue(languageList.get(i));
            }

            if (i < levelList.size()) {
                row.createCell(1).setCellValue(levelList.get(i));
            }
        }

        // Save workbook
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Excel file updated successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
