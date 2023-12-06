package stepsDefinition2;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class RegistrationStep extends BaseClass {
	
	protected WebDriver driver;
	protected HomePage hp;
	protected LoginPage lp;
	protected MyAccountPage macc;
	protected AccountRegistrationPage arp;
	protected Logger logger; //for logging
	protected ResourceBundle rb; // for reading properties file
	protected String br; //to store browser name
	
    
    @Before
    public void setup()    //Junit hook - executes once before starting
    {
        //for logging
        logger= LogManager.getLogger(this.getClass());
        rb=ResourceBundle.getBundle("config");
        br=rb.getString("browser");
       
    }
    
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status ======>"+scenario.getStatus());
       if(scenario.isFailed()) {
        	
        	TakesScreenshot ts2=(TakesScreenshot) driver;
        	byte[] screenshot=ts2.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }   
        driver.quit();
   }   
	
   
    @Given("User launch registration page")
    public void user_launch_registration() {
    	if(br.equals("chrome"))
    	{
    		driver = new ChromeDriver();
    	}
    	else if(br.equals("edge"))
    	{
    		driver = new EdgeDriver();
    	}
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("opens the URL {string}")
    public void opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
   
    @When("user navigates to MyAccount menu")
    public void user_navigates_to_my_account_menu() {
    	hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("Clicked on My Account menu ");
    }

    @When("click on register")
    public void click_on_register() {
       hp.clickRegister();
        logger.info("Clicked on register");
    }

    @When("I enter my First Name as {string}")
    public void i_enter_my_first_name_as(String string) {
    	arp = new AccountRegistrationPage(driver);
        arp.setFirstName(randomString().toUpperCase());
        logger.info("First name is entered");
    }

    @When("I enter my Last Name as {string}")
    public void i_enter_my_last_name_as(String string) {
    	arp = new AccountRegistrationPage(driver);
        arp.setLastName(randomString().toUpperCase());
        logger.info("Last name is entered");
    }

    @When("I enter my email as {string}")
    public void i_enter_my_email_as(String string) {
    	arp = new AccountRegistrationPage(driver);
    	arp.setEmail(randomEmail().toLowerCase());
    	logger.info("Email is entered");
    }

    @When("I enter my telephone as {string}")
    public void i_enter_my_telephone_as(String string) {
    	arp = new AccountRegistrationPage(driver);
        arp.setTelephone(randomNumber());
        logger.info("Phone Number is entered");
    }

    @When("I set my password as {string}")
    public void i_set_my_password_as(String string) {
    	arp = new AccountRegistrationPage(driver);
    		arp.setPassword("test@123");
    		logger.info("Password is entered");
    }

    @When("I confirm my password as {string}")
    public void i_confirm_my_password_as(String string) {
    		arp = new AccountRegistrationPage(driver);
    		arp.setPassword("test@123");
    		logger.info("Pasword is confirmed");
    }

    @When("I have read, agreed and clicked the privacy policy checkbox")
    public void i_have_read_agreed_and_clicked_the_privacy_policy_checkbox() {
    	arp = new AccountRegistrationPage(driver);
        arp.setPrivacyPolicy();
        logger.info("Privacy Policy checkbox is clicked");
    }

    @When("I click on the Continue button")
    public void i_click_on_the_continue_button() {
    	arp = new AccountRegistrationPage(driver);
        arp.clickContinue();
        logger.info("Continue button is clicked");
    }

    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
    	arp = new AccountRegistrationPage(driver);
    	arp.getConfirmationMsg();        
    }
   
    
	
	
}
