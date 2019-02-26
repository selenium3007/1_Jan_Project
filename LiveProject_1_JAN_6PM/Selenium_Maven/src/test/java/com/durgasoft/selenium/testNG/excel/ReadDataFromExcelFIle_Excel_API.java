package com.durgasoft.selenium.testNG.excel;

import org.testng.annotations.Test;

public class ReadDataFromExcelFIle_Excel_API {
  @Test
  public void f() throws Exception{
	  Excel_API e=new Excel_API
			  ("D:\\LiveProject_1_JAN_6PM\\Selenium_Maven\\testdata\\login.xlsx");
	  System.out.println("--Read data from excel file by using column num-----");
	  System.out.println(e.getCellData("Sheet1", 0, 1));
	  System.out.println(e.getCellData("Sheet1", 1, 1));
	  System.out.println(e.getCellData("Sheet1", 2, 1));
	  System.out.println("--Read data from excel file by using column Name-----");
	  System.out.println(e.getCellData("Sheet1", "User Name", 2));
	  System.out.println(e.getCellData("Sheet1", "Password", 2));
	  System.out.println(e.getCellData("Sheet1", "Status", 2));
	  System.out.println("-----set cell data to excel file by using col index------");
	  System.out.println(e.setCellData("Sheet1",2, 5,"FAILED"));
	  System.out.println("-----set cell data to excel file by using col Name------");
	  System.out.println(e.setCellData("Sheet1","Status", 6,"SKIPPED"));
	  
  }
}
