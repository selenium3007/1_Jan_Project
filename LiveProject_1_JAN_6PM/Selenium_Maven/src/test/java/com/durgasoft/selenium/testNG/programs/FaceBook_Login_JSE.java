package com.durgasoft.selenium.testNG.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class FaceBook_Login_JSE {

	public WebDriver driver;

	@Test
	public void f() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('email').value='mahesh'");
		js.executeScript("document.getElementById('pass').value='mahesh'");
		js.executeScript("document.getElementById('u_0_2').click()");
	}

	@BeforeTest
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
	}

}
