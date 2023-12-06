package testBase;

import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class BaseClass {
    
    public String randomString() // For random data to be generated
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return (generatedString);
	}
	
	public String randomEmail()
	{
		String generatedEmailId = RandomStringUtils.randomAlphabetic(4);
	//	String generatedEmailDomain = RandomStringUtils.randomNumeric(3);
		
		return (generatedEmailId + "@" + "gmail.com");
	}
    
	public String randomNumber()
	{
		String generatedPhoneNumber = RandomStringUtils.randomNumeric(10);
		return (generatedPhoneNumber);
	}
	
	   
}
