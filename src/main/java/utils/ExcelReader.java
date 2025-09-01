package utils;

	import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelReader {

		public static Object[][] getTestData(String filePath) throws IOException{
			FileInputStream fi = new FileInputStream(filePath);
			XSSFWorkbook workbook = new XSSFWorkbook(fi);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getPhysicalNumberOfCells()-1;
			
			Object[][] data = new Object[rows-1][cols];
			//System.out.println(Arrays.toString(data));
			
			for(int i = 1; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					//System.out.println(sheet.getRow(i).getCell(j).toString());
					try {
						data[i-1][j] = sheet.getRow(i).getCell(j).toString();
					}catch(NullPointerException e) {
						data[i-1][j] = "";
					}
					
				}
			}
			workbook.close();
			return data;
		}
	}

