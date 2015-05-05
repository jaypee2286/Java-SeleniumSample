/*
 * 
 * This is a utility class. Global utility methods can be found here.
 * NOTE: captureScreenshot method file save path must be changed by user.
 * 
 * */

package utility;

import static org.junit.Assert.assertTrue;
import java.io.File;
import objectRepository.Base;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ObjectUtils extends Base {
	
	@Rule
	public static ErrorCollector errorCollector = new ErrorCollector();
	
	public ObjectUtils(WebDriver driver){
		super(driver);
	}
	
	public static boolean verifyObj(By locator) {
		if(driver.findElements(locator).size() != 0) {
			System.out.println("Element is present.");
			return true;
		} else {
			System.out.println("Element does not exist.");
			return false;
		}
	}	
	
	public static void checkExistence(By locator, String failMsg){
		try {
			if(driver.findElements(locator).size() != 0) {
				System.out.println("Element is present.");
				assertTrue(true);
			} else {
				System.out.println("Element does not exist.");
				assertTrue(false);
			}
		} catch (Throwable t) {
			System.out.println(failMsg);
			System.out.println(t);
			errorCollector.addError(t);
		}
	}
	
	
	public static void captureScreenshot(WebDriver driver) {
		try {
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile,  new File("C:\\Users\\john_canlas\\Desktop\\Work\\Workspace\\screenshot.png"));
		} catch (Exception e) {
			System.out.println("Failed to take screenshot: " + e);
		}
	}
}
