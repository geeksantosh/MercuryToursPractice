package com.mercurytours.PageObject;


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

		Select selectPassanger = new Select(passengers);
		selectPassanger.selectByVisibleText("2");

		Select selectDepartingFrom = new Select(departingFrom);
		selectDepartingFrom.selectByVisibleText("Paris");

		Select selectDepartingOnMonth = new Select(departingOnMonth);
		selectDepartingOnMonth.selectByVisibleText("June");

		Select selectDepartingOnDay = new Select(departingOnDay);
		selectDepartingOnDay.selectByVisibleText("20");

		Select selectArrivingIn = new Select(arrivingIn);
		selectArrivingIn.selectByVisibleText("London");


		Select selectReturningMonth = new Select(returningMonth);
		selectReturningMonth.selectByVisibleText("June");

		Select selectReturningDay = new Select(returningDay);
		selectReturningDay.selectByVisibleText("22");

	}
}
