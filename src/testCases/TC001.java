/*
 * 
 * This is a test case class using JUnit. 
 * Test case steps can be found in the data package.
 * It can be run individually but is also part of a suite - JunitSuiteDriver.java
 * Suite class can be found in the SUITES package.
 * 
 * */

package testCases;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import objectRepository.Base;
import objectRepository.OR_Bing;
import utility.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.seleniumhq.jetty7.util.log.Log;
import org.junit.*;

public class TC001 {
	
	public WebDriver driver;
		
	@Before
	public void init() throws Exception {
		//Set log4j layout
		DOMConfigurator.configure("log4j.xml");
		
		//Set Firefox driver and 5 second implicit wait
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		new Base(driver);
	}
	  
	@Test
	public void main() throws Exception {
		try {
			//Navigate to www.bing.com
			driver.get("http://www.bing.com/");
			Log.info("Navigated to www.bing.com");
			
			//Type in Google Chrome in the search bar, then click the search button
			OR_Bing.field_Search().sendKeys("Google Chrome");
			OR_Bing.button_Search().click();
			Log.info("Inputted 'Google Chrome' in the search field and clicked the search button.");
			
			//Verify that a list of results was returned using assertTrue and verifyObj method
			assertTrue("Results Box does not exist!", Utils.verifyObj(OR_Bing.resultsBox));
			Log.info("Verified search results box loaded.");
			
		} catch (Exception e) {
			Utils.captureScreenshot(driver, "JunitScreenshot");
		}
	}
	  
	@After
	public void afterMethod() throws Exception {
		driver.close();
	}
}
