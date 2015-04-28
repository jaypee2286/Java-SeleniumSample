package testCases;


import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import objectRepository.OR_Bing;
import utility.*;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;

public class TC002 {
	
	public WebDriver driver;
	public OR_Bing BingRepo;
	
	@Before
	public void init() throws Exception {
		//Set log4j layout
		DOMConfigurator.configure("log4j.xml");
		
		//Set Firefox driver and 5 second implicit wait
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	  
	@Test
	public void main() throws Exception {
		//Navigate to www.bing.com
		BingRepo = new OR_Bing(driver);
		driver.get("http://www.bing.com/");
		
		//Type in Google Chrome in the search bar, then click the search button
		BingRepo.field_Search().sendKeys("Internet Explorer");
		BingRepo.button_Search().click();
		
		//Verify that a list of results was returned using assertTrue and verifyObj method
		assertTrue("Results Box does not exist!", ObjectUtils.verifyObj(driver, BingRepo.resultsBox));
		
		//Verify that a list of results was returned using ExpectedConditions
		new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(BingRepo.resultsBox));
	}
	  
	@After
	public void afterMethod() throws Exception {
		driver.close();
	}	
}
