package com.durgasoft.selenium.testNG.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_API {

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook w = null;
	public XSSFSheet s = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	String filePath;

	public Excel_API(String file) throws Exception {
		this.filePath = file;
		fis = new FileInputStream(filePath);
		w = new XSSFWorkbook(fis);
		fis.close();
	}

	// Reading cell data from excel file by using index
	public String getCellData(String sheetName, int colNum, int rowNum) {
		try {
			s = w.getSheet(sheetName);
			row = s.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return " ";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No matching value";
		}

	}

	// Reading cell data from excel file by using column name
	public String getCellData(String sheetName, String colName, int rowNum) {
		try {
			int colNum = -1;
			s = w.getSheet(sheetName);
			row = s.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				//System.out.println(row.getCell(i).getStringCellValue());
				if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
					colNum = i;
				}
			}
			row = s.getRow(rowNum);
			cell = row.getCell(colNum);
			if (cell.getCellTypeEnum() == CellType.STRING) {
				return cell.getStringCellValue();
			} else if (cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA) {
				String cellValue = String.valueOf(cell.getNumericCellValue());
				return cellValue;
			} else if (cell.getCellTypeEnum() == CellType.BLANK) {
				return " ";
			} else {
				return String.valueOf(cell.getBooleanCellValue());
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "No matching value";
		}
	}
	
	//Writing cell data top excel file by using column index
	public Boolean setCellData(String sheetName,int colNum,int rowNum,String value) throws Exception{
		try {
			s=w.getSheet(sheetName);
			row=s.getRow(rowNum);
			if(row==null)
				row=s.createRow(rowNum);
			cell=row.getCell(colNum);
			if(cell==null)
				cell=row.createCell(colNum);
			cell.setCellValue(value);
			fos=new FileOutputStream	(filePath);
			w.write(fos);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	//Writing cell data top excel file by using column Name
		public Boolean setCellData(String sheetName,String colName,int rowNum,String value) throws Exception{
			try {
				int colNum=-1;
				s=w.getSheet(sheetName);
				row=s.getRow(0);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					//System.out.println(row.getCell(i).getStringCellValue());
					if (row.getCell(i).getStringCellValue().equalsIgnoreCase(colName)) {
						colNum = i;
					}
				}
				row=s.getRow(rowNum);
				if(row==null)
					row=s.createRow(rowNum);
				cell=row.getCell(colNum);
				if(cell==null)
					cell=row.createCell(colNum);
				cell.setCellValue(value);
				fos=new FileOutputStream	(filePath);
				w.write(fos);
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
	//Identify no-of rows and columns in excel file
		public int getRows(String sheetName) {
			s=w.getSheet(sheetName);
			int rowCount=s.getLastRowNum()+1;
			return rowCount;
			
		}
	
		public int getColumns(String sheetName) {
			s=w.getSheet(sheetName);
			row=s.getRow(0);
			int colCount=row.getLastCellNum();
			return colCount;
			
		}
}









