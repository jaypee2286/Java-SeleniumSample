/*
 * 
 * This is a utility class. Global utility methods can be found here.
 * 
 * */

package utility;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjectUtils {
	
	@Rule
	public ErrorCollector errorCollector = new ErrorCollector();
	
	
	public boolean verifyObj(WebDriver driver, By locator) {
		if(driver.findElements(locator).size() != 0) {
			System.out.println("Element is present.");
			return true;
		} else {
			System.out.println("Element does not exist.");
			return false;
		}
	}
	
	
	public void checkExistence(String failMsg, By locator, WebDriver driver){
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
	
}
