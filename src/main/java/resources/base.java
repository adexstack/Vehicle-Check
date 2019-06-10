package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class base {
		private String projectRootDir;
		public static WebDriver driver; // creating driver object only once for all testcases
		public Properties prop;  // declaring Properties at a global level to allow inheritance access from other class
	  
	public WebDriver initializeDriver() throws IOException
	  {
		  projectRootDir = System.getProperty("user.dir").trim();
		  prop = new Properties();
		  String resourcesDirectory = (File.separator + "src" + File.separator + "main" + File.separator+ "java" + File.separator + "resources" + File.separator);
		  FileInputStream fis = new FileInputStream(projectRootDir + resourcesDirectory + "commonData.properties");
		  
		  prop.load(fis);
		  String browserName = prop.getProperty("browser");
		  		  
		  if(browserName.equals("chrome"))
			  {
			  System.setProperty("webdriver.chrome.driver", projectRootDir +  File.separator  + "chromedriver");
			  driver = new ChromeDriver();
			  }
			  
		  else if (browserName.equals("firefox"))		  		 
			{
			  System.setProperty("webdriver.gecko.driver", projectRootDir + File.separator + "geckodriver");
			  driver = new FirefoxDriver();
			}			
			 
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  return driver;			 
	  }
	
	public void getScreenshot(String result) throws IOException // Adding result to the screenshot directory to avoid overriding screenshot.png
	  {
		  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(src, new File(projectRootDir+result+"screenshot.png"));
	  }
	
	public WebElement WaitForElement(WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, 10);		
		 element = wait.until(ExpectedConditions.visibilityOf(element));
		 return element;
	}
	   
	}