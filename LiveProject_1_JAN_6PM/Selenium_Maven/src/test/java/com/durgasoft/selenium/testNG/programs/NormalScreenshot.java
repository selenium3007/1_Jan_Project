package com.durgasoft.selenium.testNG.programs;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NormalScreenshot {

	public WebDriver driver;

	@Test
	public void normalScreenShot() throws Exception {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src, new File("C:\\Users\\Mahesh\\Desktop\\sbm.png"));
		FileHandler.copy(src, new File("C:\\Users\\Mahesh\\Desktop\\sbm.png"));
	}

	@Test(enabled=false)
	public void conditionBasedScreenshot() throws Exception {
		List<WebElement> links = driver.findElements(By.partialLinkText("sunny"));
		System.out.println("Available links are:" + links.size());
		for (int i = 0; i < links.size(); i++) {
			System.out.println("Link Name:" + links.get(i).getText());
			links.get(i).click();
			Thread.sleep(5000);
		}
		if (!(links.size() == 0)) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Mahesh\\Desktop\\sbm.png"));
		}
	}
	
	@Test(enabled=false)
	public void functionalBasedScreenshot()throws Exception {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Available links are:" + links.size());
		for(int i=0;i<links.size();i++)
		{
			String linkName=links.get(i).getText();
			System.out.println(linkName);
			links.get(i).click();
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Mahesh\\Desktop\\screenshots\\"+linkName+".png"));
			links = driver.findElements(By.tagName("a"));
		}
	}
	@Test(enabled=false)
	public void dateNtimeScreenShot() throws Exception{
		Date dt=new Date();
		DateFormat dtFormat=new SimpleDateFormat("dd-MM-yyy-hh-mm-ss");
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Mahesh\\Desktop\\"
																+dtFormat.format(dt)+"sbm.png"));
		
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();
	}

}
