package testCases;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import objectRepository.Base;
import objectRepository.OR_Bing;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import utility.Utils;
import utility.Reporting;
import utility.SoftAsserts;

public class TestNG_TC002 {
	
	public WebDriver driver;
	public static final ExtentReports extent = com.relevantcodes.extentreports.ExtentReports.get(TestNG_TC002.class);
	public static SoftAsserts sassert = new SoftAsserts();
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	@BeforeClass
	public void init() throws Exception {
		//Set log4j layout
		DOMConfigurator.configure("log4j.xml");
		
		//Set Firefox driver and 5 second implicit wait
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("myProjectProfile");
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		new Base(driver);
		Reporting.extentInit(extent, "Test Suite", "TestNG_TC002");
	}
	  
	@Test (priority = 1)
	public void TestNG_TC002A() throws Exception {
		extent.startTest("TestNG_TC002");
		//Navigate to www.bing.com
		driver.get("http://www.bing.com/");
		extent.log(LogStatus.INFO, "Step 1", "Navigated to www.bing.com");
		
		//Type in Google Chrome in the search bar, then click the search button
		//OR_Bing.field_Search().sendKeys("Google Chrome");
		Utils.click(OR_Bing.field_Search);
		//driver.findElement(OR_Bing.field_Search).sendKeys("Google Chrome");
		//OR_Bing.button_Search().click();
		extent.log(LogStatus.INFO, "Step 2", "Inputted 'Google Chrome' in the search field and clicked the search button.");
		try {
			
			//Verify that a list of results was returned using assertTrue and verifyObj method
			//assertTrue("Results Box does not exist!", ObjectUtils.verifyObj(OR_Bing.resultsBox));
			sassert.assertTrue(Utils.verifyObj(OR_Bing.resultsBox), "Results Box does not exist!");
			sassert.assertTrue(Utils.verifyObj(OR_Bing.resultsBox), "Results Box does not exist 2!");
			sassert.assertTrue(Utils.verifyObj(OR_Bing.resultsBox), "Results Box does not exist 3!");
			Utils.captureScreenshot(driver, "TC002_Step3");
			extent.log(LogStatus.PASS, "Step 3", "Verified that the results box container loaded.");
			sassert.assertAll();
			
		} catch (AssertionError e) {
			extent.log(LogStatus.FAIL, "Test case failed\n" + e);
			extent.attachScreenshot(".\\Screenshots\\testScreenshot.png");
			Utils.captureScreenshot(driver, "testScreenshot");
		} catch (Throwable t) {
			extent.log(LogStatus.FAIL, t.toString());
		}
	}
	  
	@Test (priority = 2)
	public void TestNG_TC002B() {
		extent.startTest("Test 2");
		Log.info("TEST");
		Reporting.addInfo(extent, Log, "This is an INFO step.");
		Reporting.addFail(extent, Log, "This is a FAIL step.");
		Reporting.addPass(extent, Log, "This is a PASS step.");
		Reporting.addWarning(extent, Log, "This is a WARNING step.");
	}
	
	@AfterMethod
	public void afterMethod() throws Exception {
		extent.endTest();
	}
	
	@AfterClass
	public void afteClass() throws Exception {
		driver.close();
	}

}
