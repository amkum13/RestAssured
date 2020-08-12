package util;

public class ExcelUtilTest {

	public static void main(String[] args) {
		
		String excelPath = "./data/Testdata.xlsx";
		String sheetName = "Sheet1";
		
		ExcelUtils excelUtil = new ExcelUtils(excelPath, sheetName);
		
		excelUtil.getRowCount();
		excelUtil.getCellData(1, 2);
		excelUtil.getCellData(1, 1);
	}

}
