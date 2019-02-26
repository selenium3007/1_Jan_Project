package com.durgasoft.selenium.testNG.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

public class NOtificationAlerts_DefaultProfile {

	public WebDriver driver;

	@Test
	public void f() {
	}

	@BeforeTest
	public void beforeTest() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissons.default.desktop-notifications", 1);
		DesiredCapabilities capabalities = DesiredCapabilities.firefox();
		capabalities.setCapability(FirefoxDriver.PROFILE, profile);
		driver = new FirefoxDriver(capabalities);
		driver.get("http://icicibank.com");
		driver.manage().window().maximize();
	}

}
