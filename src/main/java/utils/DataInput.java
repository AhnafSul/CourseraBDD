//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.DataProvider;
//
//@DataProvider(name = "formData")
//    public static Object[][] getFormData() throws IOException {
//        String filePath = "src/test/resources/TestData.xlsx"; // Adjust path
//        FileInputStream fis = new FileInputStream(filePath);
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet sheet = workbook.getSheetAt(0);
//
//        List<Object[]> dataList = new ArrayList<>();
////        Iterator<XSSFRow> rowIterator = sheet.iterator();
//        int maxRow = sheet.getLastRowNum();
//
////        if (rowIterator.hasNext()) rowIterator.next();  // Skip header
//
////        while (rowIterator.hasNext()) {
////        	XSSFRow row = rowIterator.next();
////            XSSFCell executeCell = row.getCell(row.getLastCellNum() - 1); // Last column = Execute
////
////            if (executeCell != null && executeCell.getCellType() == CellType.BOOLEAN && executeCell.getBooleanCellValue()) { //do we need to check both cell typr 
////                Object[] rowData = new Object[row.getLastCellNum() - 1]; // Exclude Execute column
////                for (int i = 0; i < rowData.length; i++) {
////                    rowData[i] = row.getCell(i);
////                }
////                dataList.add(rowData);
////            }
////        }
//        
//        for(int i = 1; i < maxRow; i++) {
//        	
//        }
//
//        workbook.close();
//        return dataList.toArray(new Object[0][]);
//    }
//
//    private static Object getCellValue(Cell cell) {
//        if (cell == null) return "";
//
//        switch (cell.getCellType()) {
//            case STRING:
//                return cell.getStringCellValue();
//            case NUMERIC:
//                return cell.getNumericCellValue();
//            case BOOLEAN:
//                return cell.getBooleanCellValue();
//            case FORMULA:
//                return cell.getCellFormula();
//            default:
//                return "";
//        }
//    }