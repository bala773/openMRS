package bddPractises;

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

	public @FindBy(how = How.ID, using = "username") WebElement username;
	public@FindBy(how = How.ID, using = "password") WebElement password;
	public@FindBy(how = How.ID, using = "Registration Desk") WebElement RegistrationDesk;
	public@FindBy(how = How.ID, using = "loginButton") WebElement loginButton;

	public void setUsername(String admin) {
		username.sendKeys(admin);
	}

	public void setPassword(String passwrd) {
		password.sendKeys(passwrd);
	}

	public void clickRegistration() {
		RegistrationDesk.click();
	}

	public void clickLogin() {
		loginButton.click();
	}

}
