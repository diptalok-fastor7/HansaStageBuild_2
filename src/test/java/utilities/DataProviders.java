package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider (name = "LoginData")
	public Object[][] getData() throws Exception {
		String path = ".\\testData\\Credential data.xlsx";
		ExcelUtility xlUtil = new ExcelUtility(path);
		String sheetName = xlUtil.getSheetName();
		int rowCount = xlUtil.getRowCount(sheetName);
		int cellCount = xlUtil.getCellCount(sheetName, 2);
		
		Object loginData[][] = new Object[rowCount][cellCount];
		
		for (int i = 1; i<=rowCount; i++) {
			for (int j = 0; j<cellCount; j++) {
				loginData[i-1][j] = xlUtil.getCellData(sheetName, i, j);
			}
		}
		
		return loginData;
		
	}

}
