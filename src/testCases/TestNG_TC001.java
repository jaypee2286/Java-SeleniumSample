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

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.Assert;

import utility.Utils;
import utility.Reporting;

import com.relevantcodes.extentreports.*;

public class TestNG_TC001 {
	
	public WebDriver driver;
	public ErrorCollector err = new ErrorCollector();
	public static final ExtentReports extent = com.relevantcodes.extentreports.ExtentReports.get(TestNG_TC001.class);
	private static Logger Log = Logger.getLogger(Logger.class.getName());
	
	@BeforeClass
	public void initDriver() throws Exception {
		//Set log4j layout
		DOMConfigurator.configure("log4j.xml");
		
		//Set Firefox driver and 5 second implicit wait
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("myProjectProfile");
		driver = new FirefoxDriver(myprofile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		new Base(driver);
		Reporting.extentInit(extent, "Test Suite", "TestNG_TC001");
	}
	
	
	@Test
	public void TestNG_TC001A() {
		extent.startTest("TestNG_TC001");
		extent.log(LogStatus.INFO, "INFO", "Starting test.");
		extent.log(LogStatus.PASS, "Step 1", "Step 1 PASSED.");
		extent.log(LogStatus.PASS, "Step 2", "Step 2 PASSED.");
		extent.log(LogStatus.PASS, "Step 3", "Step 3 PASSED.");
		Reporting.addFail(extent, Log, "Step 4 FAILED!");
		extent.endTest();
		extent.startTest("TC001B");
		extent.log(LogStatus.PASS, "Step 1", "This is a description of the step.");
		extent.log(LogStatus.PASS, "Step 2", "This is a description of the step.");
		extent.log(LogStatus.PASS, "Step 3", "This is a description of the step.");
		extent.log(LogStatus.PASS, "Step 4", "This is a description of the step.");
		extent.log(LogStatus.PASS, "Step 5", "This is a description of the step.");
		extent.log(LogStatus.PASS, "Step 6", "This is a description of the step.");
	}
	
	@AfterMethod
	public void afterMethod() throws Exception {
		extent.endTest();
	}
	
	@AfterClass
	public void afterClass() throws Exception {
		driver.close();
	}

}
