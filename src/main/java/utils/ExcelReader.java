package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static Object[][] getTestData(String filePath) throws IOException {
        try (FileInputStream fi = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fi)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            List<Object[]> filteredData = new ArrayList<>();

            for (int i = 1; i <= rows; i++) {
                Cell executeCell = sheet.getRow(i).getCell(cols - 1); 
                boolean shouldExecute = false;

                if (executeCell != null) {
                    if (executeCell.getCellType() == CellType.BOOLEAN) {
                        shouldExecute = executeCell.getBooleanCellValue();
                    } else {
                        shouldExecute = executeCell.toString().equalsIgnoreCase("true");
                    }
                }

                if (shouldExecute) {
                    Object[] rowData = new Object[cols - 1]; // Exclude EXECUTE column
                    for (int j = 0; j < cols - 1; j++) {
                        Cell cell = sheet.getRow(i).getCell(j);
                        if (cell == null) {
                            rowData[j] = "";
                        } else if (cell.getCellType() == CellType.NUMERIC) {
                            rowData[j] = BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
                        } else {
                            rowData[j] = cell.toString();
                        }
                    }
                    filteredData.add(rowData);
                }
            }

            // Convert List to Object[][]
            Object[][] data = new Object[filteredData.size()][];
            for (int i = 0; i < filteredData.size(); i++) {
                data[i] = filteredData.get(i);
            }

            return data;
        }
    }
}
