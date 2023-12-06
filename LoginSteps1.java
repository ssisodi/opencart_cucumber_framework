package stepsDefinition1;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
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

public class LoginSteps1 extends BaseClass{
	
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
        arp = new AccountRegistrationPage(driver);
        hp = new HomePage(driver);
    }
    
    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenario status ======>"+scenario.getStatus());
        if(scenario.isFailed()) {
        	
        	TakesScreenshot ts1=(TakesScreenshot) driver;
        	byte[] screenshot=ts1.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());
        	            
        }   
        driver.quit();
   }   
     
   @Given("User Launch browser")
    public void user_launch_browser() {
        if(br.equals("chrome"))
        {
           driver=new ChromeDriver();
        }
        else if (br.equals("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("opens URL {string}")
    public void opens_url(String string) {
        driver.get(string);
        driver.manage().window().maximize();

    }
   

    @When("User navigate to MyAccount menu")
    public void user_navigate_to_my_account() {
    	hp=new HomePage(driver);
    	hp.clickMyAccount();
        logger.info("Clicked on My Account ");
    }

    @When("click on Login")
    public void click_on_login() {
        hp.clickLogin();
        logger.info("Clicked on Login ");
        
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {
    	lp=new LoginPage(driver);
         
    	lp.setEmail(email);
        logger.info("Provided Email ");
        lp.setPassword(pwd);
        logger.info("Provided Password ");
        
    }

    @When("Click on Login button")
    public void click_on_login_button() {
        lp.clickLogin();
        logger.info("Clicked on Login button");
        
    }


    @Then("User navigates to MyAccount Page")
    public void user_navigates_to_my_account_page() {
    	macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
	
        if(targetpage)
        {
            logger.info("Login Success ");
            Assert.assertTrue(true);
        }
        else
        {
            logger.error("Login Failed ");
            Assert.assertTrue(false);
        }
        
    }
   
       
 }

