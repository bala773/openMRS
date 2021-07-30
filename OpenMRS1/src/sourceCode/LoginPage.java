package sourceCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(how=How.ID,using = "username") WebElement username;
@FindBy(how=How.ID,using = "password") WebElement password;
@FindBy(how=How.ID,using = "Registration Desk") WebElement RegistrationDesk;
@FindBy(how=How.ID,using = "loginButton") WebElement loginButton;


}
