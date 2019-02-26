package com.durgasoft.selenium.testNG.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcelDataByColumnName {
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook w;
	public XSSFSheet s;
	public XSSFRow row;
	public XSSFCell cell;
  @Test
  public void f()throws Exception {
	  fi = new FileInputStream
				("D:\\LiveProject_1_JAN_6PM\\Selenium_Maven\\testdata\\login.xlsx");
		w = new XSSFWorkbook(fi);
		s = w.getSheet("Sheet1");
		row = null;
		cell = null;
		row=s.getRow(0);
		int column = -1;
		for (int i = 0; i < row.getLastCellNum(); i++) {
			System.out.println(row.getCell(i).getStringCellValue());
			if (row.getCell(i).getStringCellValue().equalsIgnoreCase("Status")) {
				column = i;
				System.out.println(column);
			}
		}
		row=s.getRow(2);
		if (row == null)
			row = s.createRow(2);
		cell=row.getCell(column);
		if (cell == null)
			cell = row.createCell(column);
		cell.setCellValue("PASS");
		fo=new FileOutputStream
				("D:\\LiveProject_1_JAN_6PM\\Selenium_Maven\\testdata\\login.xlsx");
		w.write(fo);
		fo.close();
  }
}
