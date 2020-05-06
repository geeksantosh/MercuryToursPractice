package com.mercurytours.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(how = How.NAME, using ="userName")
	@CacheLookup
	WebElement loginUsername;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement loginPassword;
	
	@FindBy(how = How.NAME, using = "login")
	@CacheLookup
	WebElement loginBtn;
	
	
	public void loginUsername(String username) {
		loginUsername.sendKeys(username);
	}
	
	public void loginPassword(String password) {
		loginPassword.sendKeys(password);
	}
	
	public void loginBtn() {
		loginBtn.click();
	}
}
