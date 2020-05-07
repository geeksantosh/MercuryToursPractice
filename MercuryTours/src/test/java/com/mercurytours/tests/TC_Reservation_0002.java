package com.mercurytours.tests;

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

		Thread.sleep(3000);
		
		ReservationPage reservation = new ReservationPage(driver);
		reservation.getRadioButtonReservation();
		logger.info(" Flight Details Radio Button data is selected");
		reservation.dropDownFlightDetails();
		logger.info("Flight Details Drop-down selection");

		
		
	

}
	
}
