package com.mercurytours.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mercurytours.PageObject.SelectFlight;

public class TC_SelectFlight_0003 extends BaseClass{
	
	@Test
	public void flightDetailSelection() throws Exception{
	SelectFlight flight = new SelectFlight(driver);
	flight.departDetails();
	logger.info("Flight Depart details are selected.");
	
	flight.returnDetails();
	logger.info("Return Flight Depart details are selected.");
	
	flight.btnContinueClick();
	logger.info("Flight Depart and return details are selected and clicked on continue button.");

	
	Thread.sleep(3000);

	String expectedURL = "http://newtours.demoaut.com/mercurypurchase.php";
	String actualURL = driver.getCurrentUrl();

	if(expectedURL.equals(actualURL)) {
		Assert.assertTrue(true);
		System.out.println("Reservation forms are filled correctly and openend new page for flight selection New URL is "+actualURL);
	}else {
		captureScreen(driver, "Select DEPART And RETURN Flight details"); 
		Assert.assertFalse(false);
		System.out.println("Reservation details couldnt be submitted. Because of form details are not completed. URl after test failed: "+ actualURL);
	}

	}

}
