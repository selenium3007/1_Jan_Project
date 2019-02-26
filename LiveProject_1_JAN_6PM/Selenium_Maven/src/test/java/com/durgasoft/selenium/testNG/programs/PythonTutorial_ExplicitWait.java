package com.durgasoft.selenium.testNG.programs;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

public class PythonTutorial_ExplicitWait {

	public WebDriver driver;

	@Test
	public void f() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.name("q")).sendKeys("python tutorial");
		Thread.sleep(5000);
		List<WebElement> ddValues = driver.findElements
				(By.xpath("//ul[@class='erkvQe']/li/div/div[@class='sbl1']/span/b"));
		for(int i=0;i<ddValues.size();i++)
		{
			System.out.println(ddValues.get(i).getAttribute("innerHTML"));
			if(ddValues.get(i).getAttribute("innerHTML").contains("point"))
			{
			wait.until(ExpectedConditions.elementToBeClickable(ddValues.get(i))).click();
				break;
			}
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
	}

}
