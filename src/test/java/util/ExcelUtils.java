package util;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	//class variables
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	//constructor
	public ExcelUtils(String excelPath, String sheetName) {
		try {
						
//			@SuppressWarnings("resource")//for resource leak--- workbook
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

			
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			System.out.println(exp.getStackTrace());
		}
	}
	
	
	public void getRowCount() {
		
		try {
			
			
			int rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("Rows Count is: "+rowCount);
			//workbook.close(); // resource close to avoid resource leak
			
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
		}
	}

public void getCellData(int rowNum, int colNum) {
		
		try {
						
//			String value = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//			
//			System.out.println("Cell [1][0] value is: "+value);
			//workbook.close(); // resource close to avoid resource leak
			
			//Dataformatter to get any type of data string double int
			
			DataFormatter formatter = new DataFormatter();
			Object values = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			System.out.println("Can hold any type of value: "+values);
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
		}
	}
}
