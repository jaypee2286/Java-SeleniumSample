package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import objectRepository.Base;

import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.GridType;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting extends Base {
	
	public static String reportLocation = ".\\Report\\"; //"C:\\Users\\john_canlas\\Desktop\\Work\\Workspace\\";
	public static String imageLocation = ".\\Report\\Screenshots\\"; //"C:\\Users\\john_canlas\\Desktop\\Work\\Workspace\\";
	
	public Reporting(WebDriver driver) {
		super(driver);
	}
	
	public static void extentInit(ExtentReports extent, String docTitle, String reportTitle){
		extent.init(reportLocation + docTitle + ".html", false, DisplayOrder.BY_OLDEST_TO_LATEST, GridType.STANDARD);
		extent.config().displayTestHeaders(false);
		extent.config().useExtentFooter(false);
		extent.config().displayCallerClass(false);
	    extent.config().documentTitle(docTitle);
		extent.config().reportTitle(reportTitle);
		extent.config().setImageSize("25%");
	    extent.config().reportHeadline("Test report for Bing search using <b>ExtentReports</b>");
	    extent.config().addCustomStylesheet("C:\\Users\\john_canlas\\Desktop\\Work\\Workspace\\font-awesome-4.3.0\\css\\fone-awesome.css");
	}
	
	public static void sassertFail(ExtentReports extent, WebDriver driver) {
		extent.log(LogStatus.FAIL, "CRITICAL", "Test case failed: ");
		extent.attachScreenshot(".\\Screenshots\\testScreenshot.png");
		Utils.captureScreenshot(driver, "testScreenshot");
	}
	
	public static void addFail(ExtentReports extent, Logger Log, String reportText) {
		//Create a date and time prefix
		DateFormat dateFormat = new SimpleDateFormat("[MM.dd.yyyy][HH.mm.ss]");
		Date date = new Date();
		
		//Capture screenshot with date and time prefix
		//Send addFail to logs
		Utils.captureScreenshot(driver, dateFormat.format(date) + reportText);
		extent.log(LogStatus.FAIL, "FAIL: " + reportText);
		extent.attachScreenshot(".\\Screenshots\\" + dateFormat.format(date) + reportText + ".png");
		Reporter.log("FAIL: " + reportText + "<br>");
		Log.info("FAIL: " + reportText);
	}
	
	public static void addPassScreenshot(ExtentReports extent, Logger Log, String reportText) {
		//Create a date and time prefix
		DateFormat dateFormat = new SimpleDateFormat("[MM.dd.yyyy][HH.mm.ss]");
		Date date = new Date();
				
		//Capture screenshot with date and time prefix
		//Send addPass to logs
		Utils.captureScreenshot(driver, dateFormat.format(date) + reportText);
		extent.log(LogStatus.PASS, reportText);
		extent.attachScreenshot(".\\Screenshots\\" + dateFormat.format(date) + reportText + ".png");
		Reporter.log("PASS: " + reportText + "<br>");
		Log.info("PASS: " + reportText);
	}
	
	public static void addPass(ExtentReports extent, Logger Log, String reportText) {
		extent.log(LogStatus.PASS, reportText);
		Reporter.log("PASS: " + reportText + "<br>");
		Log.info("PASS: " + reportText);
	}
	
	public static void addError(ExtentReports extent, Logger Log, String reportText) {
		extent.log(LogStatus.ERROR, reportText);
		Reporter.log("ERROR: " + reportText + "<br>");
		Log.info("ERROR: " + reportText);
	}
	
	public static void addWarning(ExtentReports extent, Logger Log, String reportText) {
		extent.log(LogStatus.WARNING, reportText);
		Reporter.log("WARNING: " + reportText + "<br>");
		Log.info("WARNING: " + reportText);
	}
	
	public static void addInfo(ExtentReports extent, Logger Log, String reportText) {
		extent.log(LogStatus.INFO, reportText);
		Reporter.log("INFO: " + reportText + "<br>");
		Log.info("INFO: " + reportText);
	}
	
}
