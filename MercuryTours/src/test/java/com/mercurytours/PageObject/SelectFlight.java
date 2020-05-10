package com.mercurytours.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SelectFlight {
	WebDriver ldriver;

	public SelectFlight(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	// Elements for DEPART information

	//For Flight details name
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[2]\r\n")
	@CacheLookup
	WebElement getFlightName;

	//For Price Details
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[6]/td")
	@CacheLookup
	WebElement getPriceDetails;

	//For selecting radio button
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")
	@CacheLookup
	WebElement getRadioButtonClicked;

	//Elements for RETURN flight details 

	//flight name
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[2]")
	@CacheLookup
	WebElement returnFlightName;

	//flight price
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[10]/td")
	@CacheLookup
	WebElement returnFlightPrice;

	//flight select radio button
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input")
	@CacheLookup
	WebElement returnFlightRadioButtonclick;
	
	//Continue button
	@FindBy(how = How.XPATH, using ="/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input")
	@CacheLookup
	WebElement btnContinue;



	public void departDetails() {
		String expectedFlightName = "Blue Skies Airlines 361";
		String expectedPriceDetails = "Price: $271 (based on round trip)";

		String actualFlightName =	getFlightName.getText();
		System.out.println("Actual Flight name is: "+actualFlightName );
		String ActualPriceDetail = getPriceDetails.getText();
		System.out.println("Actual Price detail is: "+ ActualPriceDetail);

		if(expectedFlightName.equals(actualFlightName) && expectedPriceDetails.equals(ActualPriceDetail)) {
			getRadioButtonClicked.click();
			System.out.println("PASS: flight Details are valid");
		}else {
			System.out.println("FAILED: flight details are invalid");
		}


	}

	public void returnDetails() {
		String expectedFlightName = "Unified Airlines 633";
		String expectedPriceDetails = "Price: $303 (based on round trip)";

		String actualFlightName =	returnFlightName.getText();
		System.out.println("Actual Flight name is: "+actualFlightName );
		String ActualPriceDetail = returnFlightPrice.getText();
		System.out.println("Actual Price detail is: "+ ActualPriceDetail);

		if(expectedFlightName.equals(actualFlightName) && expectedPriceDetails.equals(ActualPriceDetail)) {
			returnFlightRadioButtonclick.click();
			System.out.println("PASS: Return flight Details are valid");
		}else {
			System.out.println("FAILED: Return flight details are invalid");
		}

	}
	
	public void btnContinueClick() {
		btnContinue.click();
	}

}
