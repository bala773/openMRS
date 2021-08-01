package bddPractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionsClass {

	WebDriver driver;
	LoginPage logpage;
	HomePage homepage;
	RegistrationPage regpage;
	Screenshots screenshot = new Screenshots();
	public ActionsClass(WebDriver driver) {
		this.driver = driver;
		this.logpage = new LoginPage(driver);
		this.homepage = new HomePage(driver);
		this.regpage = new RegistrationPage(driver);
		this.screenshot = new Screenshots();
	
	}
	
	

	
	
	
	
}