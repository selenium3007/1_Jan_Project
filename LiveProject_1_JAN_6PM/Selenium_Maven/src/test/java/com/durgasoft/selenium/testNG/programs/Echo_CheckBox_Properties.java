package com.durgasoft.selenium.testNG.programs;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class Echo_CheckBox_Properties {

	public WebDriver driver;

	@Test
	public void f() {
		List<WebElement> checkboxValues = driver
				.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for (int i = 0; i < checkboxValues.size(); i++) {
			System.out.println(checkboxValues.get(i).getAttribute("value") + "---"
					+ checkboxValues.get(i).getAttribute("checked"));
			if (!checkboxValues.get(i).isSelected()) {
				checkboxValues.get(i).click();
			}
		}
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://echoecho.com/htmlforms09.htm");
		driver.manage().window().maximize();
	}

}
