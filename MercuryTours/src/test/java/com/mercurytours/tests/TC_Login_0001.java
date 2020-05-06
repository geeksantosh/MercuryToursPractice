package com.mercurytours.tests;

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

		if(driver.getTitle().equals("Find a Flight: Mercury Tours:")) {
			Assert.assertTrue(true);
			System.out.println("login test is passed");
		}else {
			Assert.assertFalse(false);
			System.out.println("Login test is failed");

		}
	}
}
