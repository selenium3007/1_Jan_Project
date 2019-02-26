package com.durgasoft.selenium.testNG.programs;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.BeforeTest;

public class NotificationAlerts_Firefox_UserProfile {

	public WebDriver driver;

	@Test
	public void f() {
	}

	@BeforeTest
	public void beforeTest() {
		ProfilesIni p = new ProfilesIni();
		FirefoxProfile myProfile = p.getProfile("python");
		myProfile.setPreference("dom.webnotifications.enable", false);
		driver = new FirefoxDriver(myProfile);
		driver.get("http://icicibank.com");
		driver.manage().window().maximize();
	}
}
