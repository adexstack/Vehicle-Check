package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
		
		public WebDriver driver;
		
		By vehicleRegSearch = By.id("vehicleReg");
		By vehicleRegSubmit = By.name("btnfind");
		By landingPageVerify = By.id("dlg-dealersearch-subtitle");
		By vehicleSearchResultField = By.cssSelector(".result");
		By errorMessageField = By.cssSelector(".error-required");
		String landingPageVerifyText = "Please enter the vehicle registration";
		String resultSuccessStartsText = "Result for : ";
		String resultFailureText = "Sorry record not found";
		String errorMessageText = "Please enter a valid car registration";
		String validRegistrationNumber = "OV12UYY";
				
		
		public LandingPage(WebDriver driver) { // getting live for the driver
			// TODO Auto-generated constructor stub
			
			this.driver = driver; //getting the driver variable from the current class and assigning to driver again
		}

		public WebElement getVehicleRegSearch()
		{
			return driver.findElement(vehicleRegSearch);
		}
		public WebElement getVehicleRegSubmit()
		{
			return driver.findElement(vehicleRegSubmit);
		}
		public WebElement getLandingPageVerify()
		{
			return driver.findElement(landingPageVerify);
		}
		public WebElement getVehicleSearchResultField()
		{
			return driver.findElement(vehicleSearchResultField);
		}
		public WebElement geterrorMessageField()
		{
			return driver.findElement(errorMessageField);
		}
		public String getresultSuccessStartsText()
		{
			return resultSuccessStartsText;
		}
		public String getlandingPageVerifyText()
		{
			return landingPageVerifyText;
		}
		public String getresultFailureText()
		{
			return resultFailureText;
		}
		public String geterrorMessageText()
		{
			return errorMessageText;
		}
		public String getvalidRegistrationNumber()
		{
			return validRegistrationNumber;
		}
}