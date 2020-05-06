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
		reservation.dropDownFlightDetails();

		
		
	

}
	
}
