/*
 * 
 * This is an object repository class. 
 * Objects for the appropriate page should be included here.
 * They can be included as BY locators or by direct getElement methods.
 * 
 * */

package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OR_Bing extends Base {

	public static String element;
	
	//BY variables can be used...
	public static By resultsBox = By.id("b_results");
	public static By field_Search = By.id("sb_form_q");
	
	public OR_Bing(WebDriver driver){
		super(driver);
	}

	//or WebElement objects can be used...
	public static WebElement field_Search(){
		return driver.findElement(By.id("sb_form_q"));
	}

	public static WebElement button_Search(){
		return driver.findElement(By.id("sb_form_go"));
	}
			
	//Child Class containing all LINK objects
	public static class Links {
		
		public static By link_SignIn = By.id("b_results");
		
		public static WebElement link_SignIn(){
			return driver.findElement(By.linkText("Sign in"));
		}
		
		public static WebElement link_Help(){
			return driver.findElement(By.linkText("Help"));
		}
		
		public static WebElement link_AboutOurAds(){
			return driver.findElement(By.linkText("About our ads"));
		}
		
		public static WebElement link_Advertise(){
			return driver.findElement(By.linkText("Advertise"));
		}
		
		public static WebElement link_Legal(){
			return driver.findElement(By.linkText("Legal"));
		}
		
		public static WebElement link_Privacy(){
			return driver.findElement(By.linkText("Privacy and Cookies"));
		}			
	}
}
