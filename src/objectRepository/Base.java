/*
 * 
 * This is a base class that is used to initialize a global webdriver.
 * By extending this class, the user can write methods to retrieve webelements
 * 	without having to pass in a driver every time or initialize a driver for
 *  every class used. It only needs to be initialized once.
 * 
 * */

package objectRepository;

import org.openqa.selenium.WebDriver;

//USE THIS CLASS TO INITIALIZE A GLOBAL WEBDRIVER
public class Base {
	
	public static WebDriver driver;
	
	public Base(WebDriver driver){
		Base.driver = driver;
	}
	
}
