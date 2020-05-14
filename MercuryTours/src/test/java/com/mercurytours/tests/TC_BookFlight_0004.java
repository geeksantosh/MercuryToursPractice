package com.mercurytours.tests;

import org.testng.annotations.Test;

import com.mercurytours.PageObject.BookFlight;

public class TC_BookFlight_0004 extends BaseClass{
	
	@Test
	public void passangerSection() {
	BookFlight bookFlight = new BookFlight(driver);
	bookFlight.firstName("Santosh");
	logger.info("First name entered ");
	
	bookFlight.lastName("Adhikari");
	logger.info("First name entered ");

	
	bookFlight.mealOption();
	logger.info("Meal Drop-Down option selected");

	}
	

}
