/*
 * 
 * This is a utility class. Global utility methods can be found here.
 * 
 * */

package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ObjectUtils {
	
	public static boolean verifyObj(WebDriver driver, By locator) {
		if(driver.findElements(locator).size() != 0) {
			System.out.println("Element is present.");
			return true;
		} else {
			System.out.println("Element does not exist.");
			return false;
		}
	}
	
	
}
