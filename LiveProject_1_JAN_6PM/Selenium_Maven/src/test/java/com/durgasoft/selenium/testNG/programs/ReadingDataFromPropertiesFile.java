package com.durgasoft.selenium.testNG.programs;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ReadingDataFromPropertiesFile {
	public WebDriver driver;
	public String path = "./config.properties";

	public String getData(String key) throws Exception {
		File f = new File(path);
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(f);
		p.load(fi);
		return p.getProperty(key);
	}

	@Test
	public void f() throws Exception {
		driver.findElement(By.name(getData("userNameLoc"))).sendKeys(getData("userName"));
		driver.findElement(By.name(getData("passwordLoc"))).sendKeys(getData("password"));
		driver.findElement(By.name(getData("loginLoc"))).click();
	}
	@BeforeTest
	public void beforeTest() throws Exception {
		System.out.println(getData("browser"));
		driver = new FirefoxDriver();
		driver.get(getData("prodURL"));
		driver.manage().window().maximize();
	}

}
