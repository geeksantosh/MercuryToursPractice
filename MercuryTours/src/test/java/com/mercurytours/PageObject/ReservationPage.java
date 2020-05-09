package com.mercurytours.PageObject;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ReservationPage {
	WebDriver driver;

	public ReservationPage(WebDriver rdriver){
		driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@type = 'radio' and @value = 'roundtrip']")
	@CacheLookup
	WebElement roundTrip;

	@FindBy(how = How.XPATH, using = "//input[@type = 'radio' and @value = 'oneway']")
	@CacheLookup
	WebElement onewayTrip;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input")
	@CacheLookup
	WebElement btnContinue;


	//Flight Details Radio Buttons
	public void getRadioButtonReservation() {
		onewayTrip.click();
	}

	public void dropDownFlightDetails() {
		//WebElements for  Flight Details drop-down menus
		WebElement passengers = driver.findElement(By.xpath("//select[@name = 'passCount']"));
		WebElement departingFrom = driver.findElement(By.xpath("//select[@name = 'fromPort']"));
		WebElement departingOnMonth = driver.findElement(By.xpath("//select[@name = 'fromMonth']"));
		WebElement departingOnDay = driver.findElement(By.xpath("//select[@name = 'fromDay']"));
		WebElement arrivingIn = driver.findElement(By.xpath("//select[@name = 'toPort']"));
		WebElement returningMonth = driver.findElement(By.xpath("//select[@name = 'toMonth']"));
		WebElement returningDay = driver.findElement(By.xpath("//select[@name = 'toDay']"));

		String departingOn = "June-20";
		String departingOnArr[] = departingOn.split("-");

		String returning = "June-22";
		String returningArr[] = returning.split("-");

		selectValueFromDropDown(passengers, "2");
		selectValueFromDropDown(departingFrom, "Paris");
		selectValueFromDropDown(departingOnMonth,departingOnArr[0]);
		selectValueFromDropDown(departingOnDay, departingOnArr[1]);
		selectValueFromDropDown(arrivingIn, "London");
		selectValueFromDropDown(returningMonth, returningArr[0]);
		selectValueFromDropDown(returningDay, returningArr[1]);


	}

	public void selectValueFromDropDown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	//Preference details for service class

	public void preferencesDetails(){
		int serviceClassRadioButtons =  driver.findElements(By.xpath("//input[@name = 'servClass' and @type = 'radio']")).size();
		System.out.println("The size is "+ serviceClassRadioButtons);

		for(int i=0; i<serviceClassRadioButtons; i++ ) {
			driver.findElement(By.xpath("//input[@value = 'First']")).click();
		}

		//Airline preferences drop-down validation.

		WebElement airlineElement = driver.findElement(By.xpath("//select[@name = 'airline']"));
		Select airlinePreference = new Select(airlineElement);

		List<WebElement> airelineDropDownValues = airlinePreference.getOptions();

		List<String> actualDropDownValues = new ArrayList<String>();
		for(WebElement eleDropDownValues : airelineDropDownValues) {
			actualDropDownValues.add(eleDropDownValues.getText());
			//System.out.println(eleDropDownValues.getText());
			
			driver.findElement(By.xpath("//option[contains(text(), 'Unified Airlines')]")).click();
		}

		String axpectedValues = "No Preference;Blue Skies Airlines;Unified Airlines;Pangea Airlines";
		List<String> expectedDropDownValues = new ArrayList<String>(Arrays.asList(axpectedValues.split(";")));

		//comparing drop-down values
		if(actualDropDownValues.equals(expectedDropDownValues)) {
			System.out.println("Aireline Preferences Drop-down test passed "+expectedDropDownValues + " Actual Drop-down Values: "+actualDropDownValues);

		}else {

			if(actualDropDownValues.size()>expectedDropDownValues.size()) {

				System.out.println("Aireline Preferences Drop-down test is failed, Dropdown values are not matching "+expectedDropDownValues + " Actual Drop-down Values: "+actualDropDownValues);
				actualDropDownValues.removeAll(expectedDropDownValues);
				System.out.println("Additional values are "+ actualDropDownValues);

			}else {

				System.out.println("Aireline Preferences Drop-down test is failed, Dropdown values are not matching "+expectedDropDownValues + " Actual Drop-down Values: "+actualDropDownValues);
				expectedDropDownValues.removeAll(actualDropDownValues);
				System.out.println("Missing values are "+ expectedDropDownValues);

			}
		}
		
	}
	
	//for clicking on continue button
	public void clickOnContinueButton() {
		btnContinue.click();
	}
}
