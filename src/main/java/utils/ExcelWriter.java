package utils;
 
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import base.DriverFactory;

import org.apache.poi.ss.usermodel.*;
 
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
public class ExcelWriter {
	private static Workbook workbook;
    private static Sheet sheet;
 
    public static void writeOnExcel(List<String> languageList, List<String> levelList, String fileName, String sheetNamePrefix, String header1, String header2) {
        
 
        File file = new File(fileName);
        if (file.exists() && file.length() > 0) {
            try (FileInputStream fis = new FileInputStream(file)) {
                workbook = new XSSFWorkbook(fis);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        } else {
            workbook = new XSSFWorkbook(); 
        }
 
 
        
        
        
       
        sheet = workbook.createSheet(sheetNamePrefix);
 
        // Create bold style for headers
        CellStyle boldStyle = workbook.createCellStyle();
        Font boldFont = workbook.createFont();
        boldFont.setBold(true);
        boldStyle.setFont(boldFont);
 
        // Write headers
        Row headerRow = sheet.createRow(0);
        Cell langHeader = headerRow.createCell(0);
        langHeader.setCellValue(header1);
        langHeader.setCellStyle(boldStyle);
 
        Cell levelHeader = headerRow.createCell(1);
        levelHeader.setCellValue(header2);
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
 
        
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
            workbook.close();
            System.out.println("Excel file updated successfully: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 