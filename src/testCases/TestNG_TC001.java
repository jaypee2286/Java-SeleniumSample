/*
 * 
 * This is a test case class using TestNG. 
 * Test case steps can be found in the data package.
 * It can be run individually but is also part of a suite - TestNG_Suite.xml
 * Suite properties file can be found in the project root directory.
 * 
 * */

package testCases;

import java.util.concurrent.TimeUnit;
import objectRepository.Base;
import objectRepository.OR_Bing;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import utility.ObjectUtils;

public class TestNG_TC001 {
	
	public WebDriver driver;
	public ErrorCollector err = new ErrorCollector();
	
	@BeforeClass
	public void initDriver() throws Exception {
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
			Reporter.log("Navigated to www.bing.com");
			
			//Type in Google Chrome in the search bar, then click the search button
			OR_Bing.field_Search().sendKeys("Google Chrome");
			OR_Bing.button_Search().click();
			Reporter.log("Inputted 'Google Chrome' in the search field and clicked the search button.");
			
			//Verify that the 'Sign In' link is present using Assert
			Assert.assertTrue(ObjectUtils.verifyObj(OR_Bing.Links.link_SignIn), "'Sign In' link does not exist!");
			Reporter.log("Verified 'Sign In' link loaded.");
			
			//Verify that the results are present using ExpectedConditions
			new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(OR_Bing.resultsBox));
			Reporter.log("Verified search results box loaded.");
			
		} catch (Exception e) {
			ObjectUtils.captureScreenshot(driver);
		}
	}
	
	@AfterClass
	public void afterMethod() throws Exception {
		driver.close();
	}

}
