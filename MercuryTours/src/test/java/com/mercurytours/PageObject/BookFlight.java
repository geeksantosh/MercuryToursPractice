package com.mercurytours.PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookFlight {

	WebDriver ldriver;
	public BookFlight(WebDriver rdriver){
		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	//for Passengers section
	@FindBy(how = How.XPATH, using = "//input[@name = 'passFirst0']")
	@CacheLookup
	WebElement firstName;

	@FindBy(how = How.XPATH, using = "//input[@name = 'passLast0']")
	@CacheLookup
	WebElement lastName;

	@FindBy(how = How.XPATH, using = "//select[@name = 'pass.0.meal']")
	@CacheLookup
	WebElement mealDropDown;

	//for Credit Card section
	@FindBy(how = How.XPATH, using = "//select[@name = 'creditCard']")
	@CacheLookup
	WebElement cardType;

	@FindBy(how = How.XPATH, using = "//input[@name = 'creditnumber']")
	@CacheLookup
	WebElement cardNumber;

	@FindBy(how = How.XPATH, using = "//select[@name = 'cc_exp_dt_mn']")
	@CacheLookup
	WebElement cardExpirationMM;

	@FindBy(how = How.XPATH, using = "//select[@name = 'cc_exp_dt_yr']")
	@CacheLookup
	WebElement cardExpirationYY;

	//For Billing Address


	@FindBy(how = How.XPATH, using = "//input[@name = 'billAddress1']")
	@CacheLookup
	WebElement billingAddress1;

	@FindBy(how = How.XPATH, using = "//input[@name = 'billAddress2']")
	@CacheLookup
	WebElement billingAddress2;


	@FindBy(how = How.XPATH, using = "//input[@name = 'billCity']")
	@CacheLookup
	WebElement billingCity;

	@FindBy(how = How.XPATH, using = "//input[@name = 'billState']")
	@CacheLookup
	WebElement billingState;

	@FindBy(how = How.XPATH, using = "//input[@name = 'billZip']")
	@CacheLookup
	WebElement billingPostalCode;

	@FindBy(how = How.XPATH, using = "//select[@name = 'billCountry']")
	@CacheLookup
	WebElement billingCountry;

	//For Delivery Address	

	@FindBy(how = How.XPATH, using = "//input[@name = 'delAddress1']")
	@CacheLookup
	WebElement billingDeliveryAddress1;

	@FindBy(how = How.XPATH, using = "//input[@name = 'delAddress2']")
	@CacheLookup
	WebElement billingDeliveryAddress2;


	@FindBy(how = How.XPATH, using = "//input[@name = 'delCity']")
	@CacheLookup
	WebElement billingDeliveryCity;

	@FindBy(how = How.XPATH, using = "//input[@name = 'delState']")
	@CacheLookup
	WebElement billingDeliveryState;

	@FindBy(how = How.XPATH, using = "//input[@name = 'delZip']")
	@CacheLookup
	WebElement billingDeliveryPostalCode;

	@FindBy(how = How.XPATH, using = "//select[@name = 'delCountry']")
	@CacheLookup
	WebElement billingDeliveryCountry;

	//For submit button

	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[23]/td/input")
	@CacheLookup
	WebElement btnSecurePurchase;


	public void firstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void lastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void mealOption() {
		Select selectMealDropDown = new Select(mealDropDown);
		
		List<WebElement> selectMealDropDownOption = selectMealDropDown.getOptions();
		List<String> actualMealDropDown = new ArrayList<String>();
		
		for(WebElement eleMealDropDown : selectMealDropDownOption) {
			actualMealDropDown.add(eleMealDropDown.getText());
			
			
		}
		
		
	}

}
