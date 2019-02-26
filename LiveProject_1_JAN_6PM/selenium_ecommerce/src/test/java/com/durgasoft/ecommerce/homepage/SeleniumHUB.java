package com.durgasoft.ecommerce.homepage;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumHUB {

	public static void main(String[] args) throws Exception {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setBrowserName("chrome");
		ds.setPlatform(Platform.WINDOWS);
		ChromeOptions cp=new ChromeOptions();
		 String hubURL="http://192.168.0.5:4444/wd/hub";
		 WebDriver driver=new RemoteWebDriver(new URL(hubURL), ds);
		 driver.get("http://seleniumbymahesh.com");
		 	 System.out.println(driver.getTitle());
		 	 driver.manage().window().maximize();
		 	 System.out.println(driver.getCurrentUrl());

	}

}
