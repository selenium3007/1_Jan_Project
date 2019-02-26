package com.durgasoft.selenium.testNG.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

public class ResizeObject {
	public WebDriver driver;

	@Test(enabled = false)
	public void f() {
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
		Actions a = new Actions(driver);
		// a.dragAndDropBy(drag, 500, 200).perform();
		a.clickAndHold(drag).moveByOffset(200, 500).release().build().perform();
	}

	@Test(enabled=false)
	public void rightClick() {
		//driver.switchTo().frame(0);
		WebElement element = driver.findElement(By.xpath("//*[@id='sidebar']/aside[2]/ul/li[3]/a"));
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	@Test
	public void slider() {
		driver.switchTo().frame(0);
		WebElement drag=driver.findElement(By.xpath("//*[@id='slider']/span"));
		Actions a = new Actions(driver);
		//a.clickAndHold(drag).moveByOffset(200, 0).release().build().perform();
		a.dragAndDropBy(drag, 200, 0).perform();
	
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://jqueryui.com/slider/");
		driver.manage().window().maximize();
	}

}
