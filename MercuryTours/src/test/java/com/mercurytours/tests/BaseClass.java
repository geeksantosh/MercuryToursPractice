package com.mercurytours.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mercurytours.utils.ReadConfig;

public class BaseClass {
	public static WebDriver driver;

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();

	Logger logger = LogManager.getRootLogger();


	@Parameters("browser")
	@BeforeMethod
	public void setUp(String brw) {

		if(brw.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver = new ChromeDriver();
		}

		else if(brw.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}

		else if(brw.equals("ie")) {
			System.getProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("URL is opened");
	}

	public void captureScreen(WebDriver driver, String tname) throws  IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomestring()  //For random email generator
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}

	public static String randomeNum() {  //For random number generator
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}


	/*
	 * @AfterMethod public void tearDown() { driver.quit(); }
	 */
}
