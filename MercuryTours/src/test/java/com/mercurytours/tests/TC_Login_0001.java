package com.mercurytours.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mercurytours.PageObject.LoginPage;

public class TC_Login_0001 extends BaseClass{


	@Test
	public void userLoginTest() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginUsername(username);
		loginpage.loginPassword(password);
		loginpage.loginBtn();

		Thread.sleep(3000);
		
		String expectedURL = driver.getCurrentUrl();
		String actualURL = "http://newtours.demoaut.com/mercuryreservation.php?osCsid=32ec1fd7d92a0473d0dd87185743a3f6";
		
		if(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed() == true && expectedURL.equals(actualURL)) {
			Assert.assertTrue(true);
			logger.info("Login successful");

		}else {
			Assert.assertFalse(false);
			logger.info("Login failed");
		}

	}

}
