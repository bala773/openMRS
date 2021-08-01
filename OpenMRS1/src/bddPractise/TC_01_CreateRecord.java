package bddPractise;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_01_CreateRecord {

	@Test
	public void executeScript() {	
		System.setProperty("webdriver.chrome.driver", "C:\\Automation Workspace\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
	
		LoginPage logPage= new LoginPage(driver);
		logPage.setUsername("Admin");
		logPage.setPassword("Admin123");
		logPage.clickRegistration();
		logPage.clickLogin();
		
		
		HomePage hmePage = new HomePage(driver);
		hmePage.clickReg();
		
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.setName("Scott");
		regPage.setFamilyName("Tiger");
		regPage.selectGender("Male");
		regPage.setBirthLabel("21", "April", "1991");
		regPage.setAdress("New Delhi");
		regPage.clickConfirmation();
		regPage.clickOnLogOut();
		
		driver.quit();

	}

}
