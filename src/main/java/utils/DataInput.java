package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataInput {

    @DataProvider(name = "formData")
    public static Object[][] getFormData() throws IOException {
        String filePath = "src/test/resources/TestData.xlsx"; // Adjust path
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0);

        List<Object[]> dataList = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();

        // Skip header
        if (rowIterator.hasNext()) rowIterator.next();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Cell executeCell = row.getCell(row.getLastCellNum() - 1); // Last column = Execute

            if (executeCell != null && executeCell.getCellType() == CellType.BOOLEAN && executeCell.getBooleanCellValue()) {
                Object[] rowData = new Object[row.getLastCellNum() - 1]; // Exclude Execute column
                for (int i = 0; i < rowData.length; i++) {
                    rowData[i] = getCellValue(row.getCell(i));
                }
                dataList.add(rowData);
            }
        }

        workbook.close();
        return dataList.toArray(new Object[0][]);
    }

    private static Object getCellValue(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return cell.getNumericCellValue();
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}

