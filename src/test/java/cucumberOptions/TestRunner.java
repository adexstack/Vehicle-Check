package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//Note "RunWith" is commented out because I want to run it as testng/maven test; Uncomment to run as junit test
	//@RunWith(Cucumber.class)  
	@CucumberOptions(
			features= "src/test/java/features",
	                 glue= "stepDefinitions"
	                 )
	// Also Remove "extends AbstractTestNGCucumberTests" to run as junit test
	public class TestRunner extends AbstractTestNGCucumberTests { 

	}
