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

public class OR_Bing {

	public static WebDriver driver;
	public static String element;
	
	public By resultsBox = By.id("b_resultss");
			
	public OR_Bing(WebDriver driver){
		OR_Bing.driver = driver;
	}

	public WebElement field_Search(){
		return driver.findElement(By.id("sb_form_q"));
	}

	public WebElement button_Search(){
		return driver.findElement(By.id("sb_form_go"));
	}
			
	//Child Class containing all LINK objects
	public class Links {
		
		public WebElement link_SignIn(){
			return driver.findElement(By.linkText("Sign in"));
		}
		
		public WebElement link_Help(){
			return driver.findElement(By.linkText("Help"));
		}
		
		public WebElement link_AboutOurAds(){
			return driver.findElement(By.linkText("About our ads"));
		}
		
		public WebElement link_Advertise(){
			return driver.findElement(By.linkText("Advertise"));
		}
		
		public WebElement link_Legal(){
			return driver.findElement(By.linkText("Legal"));
		}
		
		public WebElement link_Privacy(){
			return driver.findElement(By.linkText("Privacy and Cookies"));
		}			
	}
}
