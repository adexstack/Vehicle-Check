package stepDefinitions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


import PageObjects.LandingPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.base;

public class searchVehicleStepDefinition extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	@Before
	public  void StartTest() throws Throwable{
		driver = initializeDriver();
		log.info("driver is initialized");
        driver.get(prop.getProperty("coverCheckUrl"));
        log.info("Navigated to cover check page");
	}
	
	@Test
	
		@Given("^I load the covercheck insurance page$")
		public void loadInsurancePage() throws Throwable {			
	        LandingPage landingPage = new LandingPage(driver);
	        landingPage.getLandingPageVerify().getText().contains(landingPage.getlandingPageVerifyText());
	        log.info("Successfully landed on cover check page");   	    
		}

		@When("^I search by entering \"([^\"]*)\"$")
		public void enterRegNo(String registrationNumber) throws Throwable {
			LandingPage landingPage = new LandingPage(driver);
			landingPage.getVehicleRegSearch().sendKeys(registrationNumber);
			log.info(registrationNumber + " is entered");	
			landingPage.getVehicleRegSubmit().click();
					
		}

		@Then("^the search should return \"([^\"]*)\"$")
		public void validateResult(String searchReturn) throws Throwable {
			LandingPage landingPage = new LandingPage(driver);
			if(searchReturn.equals("valid result"))
			{
				Assert.assertEquals(landingPage.getVehicleSearchResultField().getText(),landingPage.getresultSuccessStartsText() + landingPage.getvalidRegistrationNumber());
				log.info("Validated " + landingPage.getVehicleSearchResultField().getText());
			}
			else if(searchReturn.equals("nothing"))
			{
				Assert.assertEquals(landingPage.getVehicleSearchResultField().getText(),landingPage.getresultFailureText());
				log.info("Validated " + landingPage.getVehicleSearchResultField().getText());
			}
			else if(searchReturn.isEmpty())
			{   
				Assert.assertEquals(WaitForElement(landingPage.getVehicleSearchResultField()).getText(),landingPage.geterrorMessageText());	
				log.info("Validated " + landingPage.getVehicleSearchResultField().getText());
			}			
	}			
		
		@After
		public void TearDown() {
			driver.quit();
			driver=null;
		}
}

	


