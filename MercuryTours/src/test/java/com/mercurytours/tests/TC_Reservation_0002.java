package com.mercurytours.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mercurytours.PageObject.LoginPage;
import com.mercurytours.PageObject.ReservationPage;

public class TC_Reservation_0002 extends BaseClass {
	
	@Test
	public void flightReservation() throws Exception {
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginUsername(username);
		loginpage.loginPassword(password);
		loginpage.loginBtn();

		Thread.sleep(5000);
		
		ReservationPage reservation = new ReservationPage(driver);
		reservation.getRadioButtonReservation();
		logger.info(" Flight Details Radio Button data is selected");
		reservation.dropDownFlightDetails();
		logger.info("Flight Details Drop-down selection");
		
		Thread.sleep(3000);
		reservation.preferencesDetails();
		logger.info("Flight Preference details has been selected");
		
		reservation.clickOnContinueButton();
		logger.info("Clicked on continue button");
		
		Thread.sleep(3000);
		
		String expectedURL = "http://newtours.demoaut.com/mercuryreservation2.php";
		String actualURL = driver.getCurrentUrl();
		
		if(expectedURL.equals(actualURL)) {
			Assert.assertTrue(true);
			System.out.println("Reservation forms are filled correctly and openend new page for flight selection New URL is "+actualURL);
		}else {
			captureScreen(driver, "loginTest"); 
			Assert.assertFalse(false);
			System.out.println("Reservation details couldnt be submitted. Because of form details are not completed. URl after test failed: "+ actualURL);
		}

		
		
}
	
}
