package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public XSSFCellStyle style;
	String path;
	
	public ExcelUtility (String path){
		this.path = path;
	}
	
	public String getSheetName() throws Exception {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		String sheetName = workbook.getSheetName(0);
		return sheetName;
	}
	
	public int getRowCount(String sheetname) throws Exception {
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fis.close();
		return rowcount;
		
	}
	
	public int getCellCount(String sheetname, int rowNo) throws Exception {
		fis = new FileInputStream (path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rowNo);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fis.close();
		return cellcount;
	}
	
	public String getCellData(String sheetname, int rowNo, int cellNo) throws Exception {
		fis = new FileInputStream (path);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		row = sheet.getRow(rowNo);
		cell = row.getCell(cellNo);
		//String cellData = cell.getStringCellValue();
		//System.out.println(cell.toString());
		DataFormatter format = new DataFormatter();
		String cellData = format.formatCellValue(cell);
		workbook.close();
		fis.close();
		return cellData;
	}

}
