package com.durgasoft.selenium.testNG;

import org.testng.annotations.Test;
import com.durgasoft.selenium.java.BasePage;
import com.durgasoft.selenium.java.PageUI;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import org.testng.annotations.BeforeTest;

public class TC001_HMS_Login_Logout extends BasePage {

	public ATUTestRecorder recorder;

	@Test(description = "This test case is to verify login & Logout in HMS")
	public void hmsLoginLogout() throws Exception {
		PageUI page = new PageUI(driver);
		page.hmsLogin();
		page.hmsLogout();
		recorder.stop();
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		recorder = new ATUTestRecorder("D:\\recording", "HMSLogin", false);
		recorder.start();
		browserLaunch("firefox", "http://seleniumbymahesh.com");

	}

}
